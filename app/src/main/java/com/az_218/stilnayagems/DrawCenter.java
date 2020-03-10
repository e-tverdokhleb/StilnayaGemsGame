package com.az_218.stilnayagems;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;

import static com.az_218.stilnayagems.GemTags.*;
import static com.az_218.stilnayagems.Storage.*;

public class DrawCenter extends View {

    public DrawCenter(Context con) {
        super(con);
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        clearScreen(c);
        drawPull(c, pullSize);
        drawGemstone(c, pullSize);
        drawPlaceholders(c);
    }

    void drawPlaceholders(Canvas c) {
        Paint p = new Paint();
        p.setTextSize((screenSize[0] - screenBounds * 2) / 5);
        for (int i = 0; i < placeholders.size(); i++) {
            Placeholder pl = placeholders.get(i);
            int plus = pl.getTime() - pl.getI() * 2;
            p.setColor(Color.argb(255, 200 + plus, 150 + plus, 50 + plus));
            if (pl.getI() == 0) placeholders.remove(i);
            c.drawText(pl.getText(), pl.getPosX(), pl.getPosY(), p);
        }


    }

    void drawGemstone(Canvas c, int size) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                gems[x][y].draw(c);
            }
        }
    }

    void drawPull(Canvas c, int size) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                c.drawBitmap(images.get(gem_pull),
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
        c.drawColor(ContextCompat.getColor(getContext(), R.color.light));
        Paint p = new Paint();
        p.setTextSize(text_size);
        c.drawText("Score: " + score, screenBounds, screenBounds + text_size, p);
        c.drawText("Checked: " + checked, screenBounds, screenBounds + text_size * 2, p);
        c.drawText("Gem spawn count: " + gem_spawn_count, screenBounds, screenBounds + text_size * 3, p);
        c.drawText("PL count: " + placeholders.size(), screenBounds, screenBounds + text_size * 4, p);
        /*p.setColor(Color.argb(50, 0, 0, 0));
        if (isTouch) c.drawCircle(mPos[0], mPos[1], pullSize / 2, p);
        p.setColor(Color.argb(25, 0, 0, 0));
        c.drawCircle(dPos[0], dPos[1], pullSize / 2, p);*/

    }

}
