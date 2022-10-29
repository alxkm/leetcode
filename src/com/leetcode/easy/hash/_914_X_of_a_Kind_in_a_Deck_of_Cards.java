package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _914_X_of_a_Kind_in_a_Deck_of_Cards {
    static public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int size = map.get(deck[0]);
        for (var entry : map.entrySet()) {
            if (entry.getValue() != size) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        System.out.println(hasGroupsSizeX(a));
    }
}
