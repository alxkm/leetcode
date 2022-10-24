package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _771_Jewels_and_Stones {
    static     public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length(); i++) {
            Integer a = map.get(stones.charAt(i));
            if (a != null) map.put(stones.charAt(i), ++a);
            else map.put(stones.charAt(i), 1);
        }
        int counter = 0;
        for (int i = 0; i < jewels.length(); i++) {
            Integer c = map.get(jewels.charAt(i));
            if (c != null) counter += c;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}
