package com.leetcode.easy.math;

import java.util.HashMap;
import java.util.Map;

public class _1812_Determine_Color_of_a_Chessboard_Square {
    public boolean squareIsWhite(String coordinates) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('a', 1);
        m.put('b', 2);
        m.put('c', 3);
        m.put('d', 4);
        m.put('e', 5);
        m.put('f', 6);
        m.put('g', 7);
        m.put('h', 8);

        char character = coordinates.charAt(0);
        int digit = (int) coordinates.charAt(1) - 48;
        if (m.get(character) % 2 == 0 && digit % 2 == 0) return false;

        return m.get(character) % 2 == 0 || digit % 2 == 0;
    }
}
