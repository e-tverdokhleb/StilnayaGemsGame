package com.az_218.stilnayagems;

import android.graphics.Canvas;

import static com.az_218.stilnayagems.Bot.initGhosts;
import static com.az_218.stilnayagems.GemTags.*;
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
        if (onTouch(dPos[0], dPos[1])) {
            selected = true;
            initGhosts(pos[0], pos[1]);
        } else {
            selected = false;
            initGhosts(-1, -1);
        }
        int plus = 0;
        if (selected && !(image.equals(gem_null) || image.equals(gem_ghost))) {
            plus = pullSize / 10;
            for (int x = 0; x < gems[1].length; x++) {
                for (int y = 0; y < gems[0].length; y++) {
                    if (gemsGhosts[x][y])
                        c.drawBitmap(images.get(gem_ghost), screenBounds + pullSize * x, screenSpaceForGem + pullSize * y, null);

                }
            }
        }

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
