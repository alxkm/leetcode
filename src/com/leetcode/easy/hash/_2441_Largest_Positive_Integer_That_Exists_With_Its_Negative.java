package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {
    //2441. Largest Positive Integer That Exists With Its Negative
    //https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/

    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int n : nums) {
            if (n > 0) {
                map.put(n, n);
            } else {
                map1.put(n, n);
            }
        }
        int max = -1;
        for (int n : nums) {
            if (n > 0) {
                var a = map.get(n);
                var b = map1.get(-n);

                if (a != null && b != null) {
                    max = Math.max(max , a);
                }
            }
        }
        return max;
    }

    public int findMaxK1(int[] nums) {
        boolean[] pos = new boolean[1001];
        boolean[] neg = new boolean[1001];
        int maxToSearch = 1000;
        int localMax = 0;
        for (int n: nums) {
            if (n < 0) neg[-n] = true;
            else pos[n] = true;

            localMax = Math.max(localMax, n);
        }
        if (localMax != 0) maxToSearch = localMax;
        int max = -1;
        for (int i = maxToSearch; i >= 0; i--) {
            if (pos[i] && neg[i]) {
                max = i;
                break;
            }
        }
        return max;
    }
}
