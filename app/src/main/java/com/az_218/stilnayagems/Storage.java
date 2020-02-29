package com.az_218.stilnayagems;

import android.app.Activity;

public class Storage {
    public static int[] screenSize;
    public static int screenBounds;
    public static DrawCenter draw;
    public static int pullSize;
    public static Gem[][] gems = new Gem[6][6];
    public static int screenSpaceForGem;

    public static void preStorageGeneration(Activity act) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                gems[x][y] = new Gem((int) (Math.random() * 4.9));
            }
        }

        screenSize = new int[]{act.getWindowManager().getDefaultDisplay().getWidth(), act.getWindowManager().getDefaultDisplay().getHeight()};

        draw = new DrawCenter(act);

        screenBounds = screenSize[0] / 30;

        pullSize = (screenSize[0] - screenBounds * 2) / gems[0].length;

        screenSpaceForGem = screenSize[1] - (screenBounds + pullSize * gems[1].length);
    }
}
