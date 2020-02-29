package com.az_218.stilnayagems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.util.Timer;
import java.util.TimerTask;

import static com.az_218.stilnayagems.Storage.*;

public class DrawCenter extends View {
    Timer myTimer;

    public DrawCenter(Context con) {
        super(con);
        start();
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        clearScreen(c);
        drawPull(c, pullSize);
        drawGemstone(c, pullSize);
    }

    void drawGemstone(Canvas c, int size) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                c.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), gems[x][y].image), size, size, false),
                        screenBounds + size * x,
                        screenSpaceForGem + size * y, null);
            }
        }
    }

    void drawPull(Canvas c, int size) {
        Bitmap b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.gem_pull), size, size, false);
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                c.drawBitmap(b,
                        screenBounds + size * x,
                        screenSpaceForGem + size * y, null);
            }
        }
    }

    /*
    void drawPlayer(Canvas c, int[] pos) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        c.drawBitmap(Bitmap.createBitmap(b, 0+(int)(Math.random()*100), 0, 100, 100, null, false), pos[0], pos[1], null);
    }*/

    void clearScreen(Canvas c) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(ContextCompat.getColor(getContext(), R.color.light));
        c.drawPaint(p);

    }

    public void start() {
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                invalidate();
            }
        }, 0, 200);
    }
}
