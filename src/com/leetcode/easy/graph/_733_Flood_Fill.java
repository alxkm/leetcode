package com.leetcode.easy.graph;

import java.util.HashSet;
import java.util.Set;

public class _733_Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) return image;
        dfs(image, sr, sc, color, image[sr][sc], new HashSet<>());
        return image;
    }

    void dfs(int[][] image, int i, int j, int color, int prevColor, Set<String> visit) {
        if (i >= image.length
                || j >= image[0].length
                || i < 0
                || j < 0) {
            return;
        }
        String s = i + String.valueOf(j);
        if (!visit.contains(s) && image[i][j] == prevColor) {
            visit.add(s);
            image[i][j] = color;

            dfs(image, i, j + 1, color, prevColor, visit);
            dfs(image, i, j - 1, color, prevColor, visit);

            dfs(image, i - 1, j, color, prevColor, visit);
            dfs(image, i + 1, j, color, prevColor, visit);

            //dfs(image, i - 1, j + 1, color, prevColor, visit);
            //dfs(image, i + 1, j - 1, color, prevColor, visit);

            //dfs(image, i + 1, j + 1, color, prevColor, visit);
            //dfs(image, i - 1, j - 1, color, prevColor, visit);
        }
    }
}
