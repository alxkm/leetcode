package com.leetcode.medium.backtrack1;

import java.util.HashSet;
import java.util.Set;

public class _1079_Letter_Tile_Possibilities {
    //1079. Letter Tile Possibilities
    //https://leetcode.com/problems/letter-tile-possibilities/description/

    Set<String> set = new HashSet<>();
    String s;
    public int numTilePossibilities(String tiles) {
        s = tiles;
        f(new StringBuilder(), new boolean[tiles.length()]);
        return set.size();
    }

    void f(StringBuilder sb, boolean[] used) {
        if (sb.length() == s.length()) return;

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(s.charAt(i));
            set.add(sb.toString());
            f(sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }}
