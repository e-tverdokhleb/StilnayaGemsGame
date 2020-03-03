package com.az_218.stilnayagems;

import android.graphics.Canvas;
import android.util.Log;

import static com.az_218.stilnayagems.Storage.*;

public class Gem {
    public String image;
    int pos[];
    boolean selected;

    public Gem(String imgId, int posX, int posY) {
        this.selected = false;
        this.pos = new int[]{posX, posY};
        this.image = imgId;
    }

    public void draw(Canvas c) {
        if (onTouch(dPos[0], dPos[1]) && selected) {
            selectedPullCount--;
            selected = false;
        }
        if (onTouch(dPos[0], dPos[1]) && !selected) {
            selectedPullCount++;
            selected = true;
        }
        if (selectedPullCount == 0)
            selected = false;
        if (selected) {
        }
        int plus = 0;
        if (selected) plus = pullSize / 10;
        c.drawBitmap(images.get(image), screenBounds + pullSize * pos[0], screenSpaceForGem + pullSize * pos[1] - plus, null);
    }

    boolean onTouch(int x, int y) {
        if (x > pos[0] * pullSize + screenBounds && x < pos[0] * pullSize + pullSize + screenBounds &&
                y > screenSpaceForGem + pos[1] * pullSize && y < screenSpaceForGem + pos[1] * pullSize + pullSize) {

            return true;
        }
        return false;
    }


}
