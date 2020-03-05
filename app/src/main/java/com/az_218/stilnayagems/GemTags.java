package com.az_218.stilnayagems;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.az_218.stilnayagems.Storage.*;

public class GemTags {
    public static final String
            gem_null = "gem_null",
            gem_pull = "gem_pull",
            gem_ghost = "gem_ghost",
            gem_blue = "gem_blue",
            gem_green = "gem_green",
            gem_magenta = "gem_magenta";

    static void initMoveRoles() {
        moveRoles.put(gem_green, 1);
        moveRoles.put(gem_magenta, 1);
        moveRoles.put(gem_blue, 1);
    }

    static void initGemBitmaps(Resources r) {
        images.put(gem_pull, getSG(r, R.drawable.gem_pull));
        images.put(gem_null, getSG(r, R.drawable.gem_null));
        images.put(gem_ghost, getSG(r, R.drawable.gem_ghost));
        images.put(gem_blue, getSG(r, R.drawable.gem_blue));
        images.put(gem_green, getSG(r, R.drawable.gem_green));
        images.put(gem_magenta, getSG(r, R.drawable.gem_magenta));
    }
}
