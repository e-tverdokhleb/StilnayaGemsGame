package com.az_218.stilnayagems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import static com.az_218.stilnayagems.GemTags.*;

public class Storage {
    public static int screenBounds, pullSize, screenSpaceForGem, score, text_size;
    public static int[] screenSize, mPos = {0, 0}, dPos = {0, 0}, uPos = {0, 0};
    public static Gem[][] gems = new Gem[7][7];
    public static boolean[][] gemsGhosts = new boolean[gems.length][gems[0].length];
    public static boolean isTouch, checked;
    public static DrawCenter draw;
    public static HashMap<String, Bitmap> images = new HashMap<>();
    public static HashMap<String, Integer> moveRoles = new HashMap<>();

    public static void preStorageGeneration(Activity act) {
        text_size = 64;

        score = 0;

        initMoveRoles();

        Bot.firstGeneration();

        isTouch = false;

        screenSize = new int[]{act.getWindowManager().getDefaultDisplay().getWidth(), act.getWindowManager().getDefaultDisplay().getHeight()};

        draw = new DrawCenter(act);

        screenBounds = screenSize[0] / 30;

        pullSize = (screenSize[0] - screenBounds * 2) / gems[0].length;

        initGemBitmaps(act.getResources());

        screenSpaceForGem = screenSize[1] - (screenBounds + pullSize * gems[1].length);
    }

    public static Bitmap getSG(Resources r, int id) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, id), pullSize, pullSize, false);
    }
}
