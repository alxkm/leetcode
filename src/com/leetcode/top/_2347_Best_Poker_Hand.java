package com.leetcode.top;

import java.util.HashMap;
import java.util.Map;

public class _2347_Best_Poker_Hand {
    //2347. Best Poker Hand
    //https://leetcade.com/problems/best-poker-hand/

    public String bestHand(int[] ranks, char[] suits) {
        Map<Character, Integer> s = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();

        for (char suit : suits) {
            s.put(suit, s.getOrDefault(suit, 0) + 1);
        }

        for (int rank : ranks) {
            r.put(rank, r.getOrDefault(rank, 0) + 1);
        }

        for (var e : s.entrySet()) {
            if (e.getValue() == 5) return "Flush";
        }

        for (var e : r.entrySet()) {
            if (e.getValue() >= 3) return "Three of a Kind";
        }

        for (var e : r.entrySet()) {
            if (e.getValue() == 2) return "Pair";
        }

        return "High Card";
    }
}
