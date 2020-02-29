package com.az_218.stilnayagems;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Gem {
    public int image;

    public Gem(int imgId) {
        this.image = getImageById(imgId);
    }

    int getImageById(int id) {
        switch (id) {
            default:
                return R.drawable.gem_green;
            case 0:
                return R.drawable.gem_blue;
            case 1:
                return R.drawable.gem_magenta;
            case 2:
                return R.drawable.gem_green;
        }
    }
}
