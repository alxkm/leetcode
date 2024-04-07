package com.leetcode.medium.backtrack;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _935_Knight_Dialer {
    //935. Knight Dialer
    //https://leetcode.com/problems/knight-dialer/

    private final Map<AbstractMap.SimpleEntry<Integer, Integer>, Integer> cache = new HashMap<>();
    private Map<Integer, List<Integer>> move = new HashMap<>();
    private final int mod = 1000000000 + 7;

    public int knightDialer(int n) {
        move.put(0, List.of(4, 6));
        move.put(1, List.of(6, 8));
        move.put(2, List.of(7, 9));
        move.put(3, List.of(4, 8));
        move.put(4, List.of(0, 3, 9));
        move.put(5, List.of());
        move.put(6, List.of(0, 1, 7));
        move.put(7, List.of(2, 6));
        move.put(8, List.of(1, 3));
        move.put(9, List.of(2, 4));

        int counter = 0;
        for (int i = 0; i < 10; i++) {
            counter = (counter + dfs(i, n - 1)) % mod;
        }
        return counter;
    }

    private int dfs(int i, int n) {
        if (n == 0) return 1;
        var pair = new AbstractMap.SimpleEntry<>(i, n);
        if (cache.get(pair) != null) {
            return cache.get(pair);
        }

        int counter = 0;
        for (int j: move.get(i)) {
            counter = (counter + dfs(j, n - 1)) % mod;
        }
        cache.put(new AbstractMap.SimpleEntry<>(i, n), counter);
        return counter;
    }
}
