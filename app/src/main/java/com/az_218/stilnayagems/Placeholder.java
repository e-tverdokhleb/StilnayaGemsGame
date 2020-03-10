package com.az_218.stilnayagems;

import static com.az_218.stilnayagems.Storage.*;

public class Placeholder extends Thread {
    private int time, posX, posY, move, text_size, i;
    private String text;

    public Placeholder(String text, int posX, int posY, int time, int moveUp, int textSize) {
        this.text = text;
        this.posX = posX;
        this.posY = posY;
        this.time = time;
        this.move = moveUp;
        this.text_size = textSize;
        this.start();
    }

    public int getI() {
        return i;
    }

    public int getPosX() {
        return posX;
    }

    public int getTextSize() {
        return text_size;
    }

    public int getPosY() {
        return posY;
    }

    public String getText() {
        return text;
    }

    @Override
    public void run() {
        for (i = time; i >= 0; i--) {
            this.posY -= move;
            try {
                Placeholder.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
