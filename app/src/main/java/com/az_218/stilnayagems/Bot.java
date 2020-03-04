package com.az_218.stilnayagems;

import android.util.Log;

import static com.az_218.stilnayagems.GemTags.*;
import static com.az_218.stilnayagems.Storage.*;

public class Bot {
    static String getRandomGem() {
        int i = (int) (Math.random() * 20);
        switch (i) {
            default:
                return gem_null;
            case 0:
                return gem_green;
            case 1:
                return gem_blue;
            case 2:
                return gem_magenta;
        }
    }

    static void firstGeneration() {
        initGhosts(-1, -1);
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                gems[x][y] = new Gem(gem_null, x, y);
            }
        }
        tryGenerate(7);
    }

    static void tryGenerate(int num) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                if (num <= 0) continue;
                String id = getRandomGem();
                if (!id.equals(gem_null)) {
                    gems[x][y] = new Gem(id, x, y);
                    num--;
                }
            }
        }
        if (num > 0) tryGenerate(num);
    }

    public static void initGhosts(int ix, int iy) {
        //(pos[1] == y || pos[0] == x) && gems[x][y].image.equals(gem_null)
                    /*if ((gems[ix][iy].pos[1] == y || gems[ix][iy].pos[0] == x) && gems[x][y].image.equals(gem_null)) {
                        gemsGhosts[x][y] = true;
                    }*/
        if (ix + iy < 0)
            for (int x = 0; x < gems[0].length; x++) {
                for (int y = 0; y < gems[1].length; y++) {
                    gemsGhosts[x][y] = false;
                }
            }
        else {
            for (int fx = ix - 1; fx > -1; fx--)
                if (gems[fx][iy].image.equals(gem_null)) gemsGhosts[fx][iy] = true;
                else fx = -1;
            for (int fx = ix + 1; fx < gems.length; fx++)
                if (gems[fx][iy].image.equals(gem_null)) gemsGhosts[fx][iy] = true;
                else fx = gems.length;

            for (int fy = iy - 1; fy > -1; fy--)
                if (gems[ix][fy].image.equals(gem_null)) gemsGhosts[ix][fy] = true;
                else fy = -1;
            for (int fy = iy + 1; fy < gems[0].length; fy++)
                if (gems[ix][fy].image.equals(gem_null)) gemsGhosts[ix][fy] = true;
                else fy = gems[0].length;
        }
    }
}
