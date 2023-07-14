package com.leetcode.medium.backtrack;

import java.util.HashSet;
import java.util.Set;

public class _1079_Letter_Tile_Possibilities {
    //https://leetcode.com/problems/letter-tile-possibilities/

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        f(used, tiles.toCharArray(), tiles.length(), new StringBuilder(), set);
        return set.size();
    }

    private void f(boolean[] used, char[] s, int n, StringBuilder sb, Set<String> set) {
        if (sb.toString().length() > 0) {
            if (set.contains(sb.toString())) return;
            set.add(sb.toString());
        }
        if (sb.length() >= n) return;

        for (int i = 0; i < s.length && sb.length() <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(s[i]);
            f(used, s, n, sb, set);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
