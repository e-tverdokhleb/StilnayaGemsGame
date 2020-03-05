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
            gem_magenta = "gem_magenta",
            gem_red= "gem_red",
            gem_aqua = "gem_aqua",
            gem_orange = "gem_orange",
            gem_yellow = "gem_yellow";

    static void initMoveRoles() {
        moveRoles.put(gem_green, 1);
        moveRoles.put(gem_magenta, 1);
        moveRoles.put(gem_blue, 1);
        moveRoles.put(gem_red, 1);
        moveRoles.put(gem_aqua, 1);
        moveRoles.put(gem_yellow, 1);
        moveRoles.put(gem_orange, 1);
    }

    static void initGemBitmaps(Resources r) {
        images.put(gem_pull, getSG(r, R.drawable.gem_pull));
        images.put(gem_null, getSG(r, R.drawable.gem_null));
        images.put(gem_ghost, getSG(r, R.drawable.gem_ghost));
        images.put(gem_blue, getSG(r, R.drawable.gem_blue));
        images.put(gem_green, getSG(r, R.drawable.gem_green));
        images.put(gem_magenta, getSG(r, R.drawable.gem_magenta));
        images.put(gem_red, getSG(r, R.drawable.gem_red));
        images.put(gem_aqua, getSG(r, R.drawable.gem_aqua));
        images.put(gem_orange, getSG(r, R.drawable.gem_orange));
        images.put(gem_yellow, getSG(r, R.drawable.gem_yellow));
    }
}
