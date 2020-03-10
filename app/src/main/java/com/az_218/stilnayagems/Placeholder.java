package com.az_218.stilnayagems;

import static com.az_218.stilnayagems.Storage.*;

public class Placeholder extends Thread {
    private int time, posX, posY, move, i;
    private String text;

    public Placeholder(String text, int posX, int posY, int time, int moveUp) {
        this.text = text;
        this.posX = posX;
        this.posY = posY;
        this.time = time;
        this.move = moveUp;
        this.start();
    }

    public Placeholder(String text, int time) {
        this.text = text;
        this.posX = screenSize[0] - screenBounds - (screenSize[0] - screenBounds * 2) / 5 * text.length();
        this.posY = screenSize[1] / 2 - pullSize;
        this.time = time;
        this.move = pullSize / time;
        this.start();
    }

    public int getI() {
        return i;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getTime() {
        return time;
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
