package com.az_218.stilnayagems;

import android.graphics.Canvas;

import static com.az_218.stilnayagems.Bot.generateRandomGems;
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
        if (isGemTouch(dPos[0], dPos[1]) && !(image.equals(gem_null) || image.equals(gem_ghost)) && isTouch) {
            selected = true;
            initGhosts(pos[0], pos[1], moveRoles.get(image));
            drawGhosts(c);
            c.drawBitmap(images.get(image), mPos[0] - pullSize / 2, mPos[1] - pullSize / 2 - pullSize / 5, null);
        } else {
            try {
                int[] putPos = new int[]{(uPos[0] - screenBounds) / pullSize, (uPos[1] - screenSpaceForGem) / pullSize};
                if (selected && !isTouch) {
                    if (gemsGhosts[putPos[0]][putPos[1]]) {
                        gems[putPos[0]][putPos[1]] = new Gem(image, putPos[0], putPos[1]);
                        this.image = gem_null;
                        gem_spawn_count = (int) (Math.random() * (score / 300)) + 1;
                        generateRandomGems(gem_spawn_count);
                    }
                    initGhosts(-1, -1, 0);
                }
                checked = false;
                selected = false;
            } catch (Exception ex) {
                selected = false;
                initGhosts(-1, -1, 0);
            }
            c.drawBitmap(images.get(image), screenBounds + pullSize * pos[0], screenSpaceForGem + pullSize * pos[1], null);
        }
    }

    void drawGhosts(Canvas c) {
        for (int x = 0; x < gems[1].length; x++) {
            for (int y = 0; y < gems[0].length; y++) {
                if (gemsGhosts[x][y])
                    c.drawBitmap(images.get(gem_ghost), screenBounds + pullSize * x, screenSpaceForGem + pullSize * y, null);
            }
        }
    }

    boolean isGemTouch(int x, int y) {
        if (/**/x > pos[0] * pullSize + screenBounds &&
                x < pos[0] * pullSize + pullSize + screenBounds &&
                y > pos[1] * pullSize + screenSpaceForGem &&
                y < pos[1] * pullSize + pullSize + screenSpaceForGem)
            return true;
        else return false;
    }


}
