package com.leetcode.medium.dp;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _576_Out_of_Boundary_Paths {
    //576. Out of Boundary Paths
    //https://leetcode.com/problems/out-of-boundary-paths/

    int m;
    int n;
    int startRow;
    int startColumn;
    Map<Pair<Pair<Integer, Integer>, Integer>, Integer> map = new HashMap<>();
    int mod = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        this.startRow = startRow;
        this.startColumn = startColumn;

        return f(startRow, startColumn, maxMove);
    }

    private int f(int i, int j, int movesLeft) {
        if (movesLeft < 0) return 0;
        if (i < 0 || j < 0 || i >= m || j >= n) return 1;
        if (movesLeft == 0) return 0;

        Pair<Pair<Integer, Integer>, Integer> key = new Pair<>(new Pair<>(i, j), movesLeft);
        var cachedValue = map.get(key);
        if (cachedValue != null) return cachedValue;

        int value = 0;
        value = (value + f(i + 1, j, movesLeft - 1)) % mod;
        value = (value + f(i, j + 1, movesLeft - 1)) % mod;
        value = (value + f(i - 1, j, movesLeft - 1)) % mod;
        value = (value + f(i, j  - 1, movesLeft - 1)) % mod;

        map.put(key, value);
        return value;
    }
}
