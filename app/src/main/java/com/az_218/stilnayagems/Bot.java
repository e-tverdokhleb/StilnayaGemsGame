package com.az_218.stilnayagems;

import android.util.Log;

import java.util.HashSet;

import static com.az_218.stilnayagems.GemTags.*;
import static com.az_218.stilnayagems.Storage.*;

public class Bot {
    static String getRandomGem() {
        int i = (int) (Math.random() * gems.length * gems[0].length);
        switch (i) {
            default:
                return gem_null;
            case 0:
                return gem_green;
            case 1:
                return gem_blue;
            case 2:
                return gem_magenta;
            case 3:
                return gem_red;
            case 4:
                return gem_aqua;
            case 5:
                return gem_orange;
            case 6:
                return gem_yellow;
        }
    }

    static void firstGeneration() {
        initGhosts(-1, -1, 0);
        for (int x = 0; x < gems.length; x++) {
            for (int y = 0; y < gems[0].length; y++) {
                gems[x][y] = new Gem(gem_null, x, y);
            }
        }
        generateRandomGems(gems.length + gems[0].length);
    }

    static void generateRandomGems(int num) {
        for (int x = 0; x < gems[0].length; x++) {
            for (int y = 0; y < gems[1].length; y++) {
                if (num <= 0) continue;
                String id = getRandomGem();
                if (!id.equals(gem_null) && gems[x][y].image.equals(gem_null)) {
                    gems[x][y].image = id;
                    num--;
                }
            }
        }
        if (num > 0) generateRandomGems(num);
    }

    public static void initGhosts(int ix, int iy, int moveRole) {
        //(pos[1] == y || pos[0] == x) && gems[x][y].image.equals(gem_null)
                    /*if ((gems[ix][iy].pos[1] == y || gems[ix][iy].pos[0] == x) && gems[x][y].image.equals(gem_null)) {
                        gemsGhosts[x][y] = true;
                    }*/
        if (ix + iy < 0 || moveRole == 0)
            for (int x = 0; x < gems[0].length; x++) {
                for (int y = 0; y < gems[1].length; y++) {
                    gemsGhosts[x][y] = false;
                }
            }
        else {
            switch (moveRole) {
                default:
                    break;
                case 1: {
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
                    break;
                }
            }
        }
    }

    public static void checkCombos() {
        HashSet<int[]> toDel = new HashSet<>();
        for (int x = 0; x < gems.length; x++) {
            for (int y = 0; y < gems[0].length; y++) {
                if (!(gems[x][y].image.equals(gem_null) || gems[x][y].image.equals(gem_ghost))) {
                    try {
                        if (gems[x][y].image.equals(gems[x + 1][y].image) && gems[x][y].image.equals(gems[x + 2][y].image)) {
                            toDel.add(new int[]{x + 0, y});
                            toDel.add(new int[]{x + 1, y});
                            toDel.add(new int[]{x + 2, y});
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (gems[x][y].image.equals(gems[x][y + 1].image) && gems[x][y].image.equals(gems[x][y + 2].image)) {
                            toDel.add(new int[]{x, y + 0});
                            toDel.add(new int[]{x, y + 1});
                            toDel.add(new int[]{x, y + 2});
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        for (int[] i : toDel) {
            gems[i[0]][i[1]].image = gem_null;
            Log.println(Log.ERROR, "-----", i[0] + " " + i[1]);
        }
        if (toDel.size() > 0)
            placeholders.add(new Placeholder("+" + toDel.size(), 25));

        score += toDel.size();
        checked = true;
    }
}
