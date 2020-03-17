package com.az_218.stilnayagems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashMap;

import static com.az_218.stilnayagems.GemTags.*;

public class Storage {
    public static int screenBounds, pullSize, screenSpaceForGem, score, text_size, gem_spawn_count;
    public static int[] screenSize, mPos = {0, 0}, dPos = {0, 0}, uPos = {0, 0};
    public static Gem[][] gems = new Gem[7][7];
    public static boolean[][] gemsGhosts = new boolean[gems.length][gems[0].length];
    public static boolean isTouch, checked, gameOver;
    public static HashMap<String, Bitmap> images = new HashMap<>();
    public static HashMap<String, Integer> moveRoles = new HashMap<>();
    public static ArrayList<Placeholder> placeholders = new ArrayList<>();

    public static void preStorageGeneration(Activity act) {

        gameOver = false;

        text_size = 64;

        score = 0;

        initMoveRoles();

        Bot.firstGeneration();

        isTouch = false;
        Point p = new Point();
        act.getWindowManager().getDefaultDisplay().getSize(p);
        screenSize = new int[]{p.x, p.y};

        screenBounds = screenSize[0] / 30;

        pullSize = (screenSize[0] - screenBounds * 2) / gems[0].length;

        initGemBitmaps(act.getResources());

        screenSpaceForGem = screenSize[1] - (screenBounds + pullSize * gems[1].length);
    }

    public static Bitmap getSG(Resources r, int id) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, id), pullSize, pullSize, false);
    }
}
