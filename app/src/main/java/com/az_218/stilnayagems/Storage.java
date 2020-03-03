package com.az_218.stilnayagems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

public class Storage {
    public static int selectedPullCount;
    public static boolean isTouch;
    public static int[] screenSize;
    public static int screenBounds;
    public static DrawCenter draw;
    public static int pullSize;
    public static Gem[][] gems = new Gem[5][5];
    public static int screenSpaceForGem;
    public static int[] mPos = {0, 0};
    public static int[] dPos = {0, 0};
    public static HashMap<String, Bitmap> images = new HashMap<>();

    public static void preStorageGeneration(Activity act) {
        selectedPullCount = 0;
        isTouch = false;
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                gems[x][y] = new Gem("gem_green", x, y);
            }
        }
        screenSize = new int[]{act.getWindowManager().getDefaultDisplay().getWidth(), act.getWindowManager().getDefaultDisplay().getHeight()};

        draw = new DrawCenter(act);

        screenBounds = screenSize[0] / 30;

        pullSize = (screenSize[0] - screenBounds * 2) / gems[0].length;

        initBitmaps(act.getResources());

        screenSpaceForGem = screenSize[1] - (screenBounds + pullSize * gems[1].length);
    }

    static void initBitmaps(Resources r) {
        images.put("gem_pull", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_pull), pullSize, pullSize, false));
        images.put("gem_green", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_green), pullSize, pullSize, false));
        images.put("gem_magenta", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_magenta), pullSize, pullSize, false));
        images.put("gem_blue", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_blue), pullSize, pullSize, false));

    }
}
