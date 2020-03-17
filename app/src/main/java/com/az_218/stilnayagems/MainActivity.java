package com.az_218.stilnayagems;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import static com.az_218.stilnayagems.Bot.checkCombos;
import static com.az_218.stilnayagems.Storage.checked;
import static com.az_218.stilnayagems.Storage.dPos;
import static com.az_218.stilnayagems.Storage.gameOver;
import static com.az_218.stilnayagems.Storage.isTouch;
import static com.az_218.stilnayagems.Storage.mPos;
import static com.az_218.stilnayagems.Storage.preStorageGeneration;
import static com.az_218.stilnayagems.Storage.uPos;

public class MainActivity extends AppCompatActivity {
    public DrawCenter draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create(this);
    }

    void create(AppCompatActivity ac) {
        draw = new DrawCenter(this);
        setContentView(draw);
        preStorageGeneration(ac);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (!(checked && gameOver)) checkCombos();
                    draw.invalidate();
                } catch (Exception ex) {
                    Log.println(Log.ERROR, "Draw-Thread", "error in draw-thread");
                }
            }
        }, 0, 20);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (gameOver) {
                    gameOver = false;
                }
                mPos = new int[]{(int) event.getX(), (int) event.getY()};
                dPos = new int[]{(int) event.getX(), (int) event.getY()};
                uPos = new int[]{0, 0};
                isTouch = true;
                return true;
            case MotionEvent.ACTION_UP:
                dPos = new int[]{0, 0};
                uPos = new int[]{(int) event.getX(), (int) event.getY()};
                isTouch = false;
                return true;
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_CANCEL:
                return true;
            case MotionEvent.ACTION_MOVE:
                mPos = new int[]{(int) event.getX(), (int) event.getY()};
                return true;
            default:
                return false;
        }
    }
}
