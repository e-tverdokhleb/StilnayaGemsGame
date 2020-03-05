package com.az_218.stilnayagems;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import static com.az_218.stilnayagems.Storage.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preStorageGeneration(this);
        preGeneration();
        setContentView(draw);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            default:
                return false;
            case MotionEvent.ACTION_DOWN:
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
                return true;
            case MotionEvent.ACTION_MOVE:
                mPos = new int[]{(int) event.getX(), (int) event.getY()};
                return true;
            case MotionEvent.ACTION_CANCEL:
                return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT < 19)
            this.getWindow().getDecorView().setSystemUiVisibility(View.GONE);
        else
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    @SuppressLint("SourceLockedOrientationActivity")
    void preGeneration() {
        if (Build.VERSION.SDK_INT < 19)
            this.getWindow().getDecorView().setSystemUiVisibility(View.GONE);
        else
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}
