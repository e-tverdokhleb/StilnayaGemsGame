package com.az_218.stilnayagems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import static com.az_218.stilnayagems.GemTags.*;

public class Storage {
    public static int screenBounds, pullSize, screenSpaceForGem;
    public static int[] screenSize, mPos = {0, 0}, dPos = {0, 0}, uPos = {0, 0};
    public static Gem[][] gems = new Gem[7][7];
    public static boolean[][] gemsGhosts = new boolean[gems.length][gems[0].length];
    public static boolean isTouch;
    public static DrawCenter draw;
    public static HashMap<String, Bitmap> images = new HashMap<>();
    public static HashMap<String, Integer> moveRoles = new HashMap<>();

    public static void preStorageGeneration(Activity act) {
        initMoveRoles();
        Bot.firstGeneration();
        isTouch = false;
        screenSize = new int[]{act.getWindowManager().getDefaultDisplay().getWidth(), act.getWindowManager().getDefaultDisplay().getHeight()};

        draw = new DrawCenter(act);

        screenBounds = screenSize[0] / 30;

        pullSize = (screenSize[0] - screenBounds * 2) / gems[0].length;

        initBitmaps(act.getResources());

        screenSpaceForGem = screenSize[1] - (screenBounds + pullSize * gems[1].length);
    }

    static void initMoveRoles() {
        moveRoles.put(gem_null, 0);
        moveRoles.put(gem_ghost, 0);
        moveRoles.put(gem_green, 1);
        moveRoles.put(gem_magenta, 1);
        moveRoles.put(gem_blue, 1);
    }

    static void initBitmaps(Resources r) {
        images.put(gem_pull, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_pull), pullSize, pullSize, false));
        images.put(gem_null, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_null), pullSize, pullSize, false));
        images.put(gem_ghost, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_ghost), pullSize, pullSize, false));
        images.put(gem_green, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_green), pullSize, pullSize, false));
        images.put(gem_magenta, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_magenta), pullSize, pullSize, false));
        images.put(gem_blue, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.gem_blue), pullSize, pullSize, false));
    }
}
