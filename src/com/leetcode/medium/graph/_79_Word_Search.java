package com.leetcode.medium.graph;

import java.util.HashSet;
import java.util.Set;

public class _79_Word_Search {
    //https://leetcode.com/problems/word-search/

    private char[][] boad;
    private char[] w;
    int m = 0;
    int n = 0;

    public boolean exist(char[][] b, String word) {
        boad = b;
        w = word.toCharArray();
        m = boad.length;
        n = boad[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boad[i][j] == w[0] && dfs(i, j, 0, new HashSet<String>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int ii, Set<String> used) {
        if (w.length == ii) return true;

        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;
        if (boad[i][j] != w[ii]) return false;

        String str = String.valueOf(i) + String.valueOf(j);
        if (used.contains(str)) return false;
        else used.add(str);

        if (ii == w.length - 1) return true;

        var right = dfs(i, j + 1, ii + 1, used);
        var left = dfs(i + 1, j, ii + 1, used);
        var down = dfs(i - 1, j, ii + 1, used);
        var up = dfs(i, j - 1, ii + 1, used);
        used.remove(str);

        return right || left || down || up;
    }

    public static void main(String[] args) {
        var a = new _79_Word_Search();
        //char[][] chars = {{'a','b'},{'c','d'}};
        char[][] chars = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'},
        };
        String w = "ABCEFSADEESE";
        System.out.println(a.exist(chars, w));
    }
}
