package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _997_Find_the_Town_Judge {
    static public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] a : trust) {
            map.put(a[0], a[1]);
        }

        int r = -1;
        for (int i = 1; i <= n; i++) {
            if (map.get(i) == null) r = i;
        }
        if (r == -1) return -1;

        int count = 0;

        for (int[] a : trust) {
            if (a[1] == r) {
                count++;
            }
        }

        System.out.println(count);

        if (count == n - 1) return r;

        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(4, a));
    }
}
