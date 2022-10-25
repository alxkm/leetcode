package com.leetcode.easy.string.additional;

import java.util.HashSet;
import java.util.Set;

public class _1496_Path_Crossing {
    static public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0.0");
        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                x++;
            }
            if (ch == 'E') {
                y++;
            }
            if (ch == 'S') {
                x--;
            }
            if (ch == 'W') {
                y--;
            }
            if (!set.add(x + "." + y)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "NNSWWEWSSESSWENNW";
        System.out.println(isPathCrossing(s));
    }
}
