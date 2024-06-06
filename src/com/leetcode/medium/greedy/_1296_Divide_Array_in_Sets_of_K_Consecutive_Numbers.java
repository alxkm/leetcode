package com.leetcode.medium.greedy;

import java.util.Map;
import java.util.TreeMap;

public class _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    //1296. Divide Array in Sets of K Consecutive Numbers
    //https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
    //https://leetcode.com/problems/hand-of-straights/

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (k == 1) return true;
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (var entry: map.entrySet()) {
            while (entry.getValue() > 0) {
                int prev = entry.getKey();
                entry.setValue(entry.getValue() - 1);
                prev++;
                for (int i = 1; i < k; i++) {
                    Integer c = map.get(prev);
                    if (c != null && c > 0) {
                        map.put(prev, c - 1);
                        prev++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isPossibleDivide1(int[] nums, int k) {
        if (k == 1) return true;
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, int[]> map = new TreeMap<>();
        for (int num : nums) {
            map.computeIfAbsent(num, key -> new int[1])[0]++;
        }

        for (var entry: map.entrySet()) {
            while (entry.getValue()[0] > 0) {
                int prev = entry.getKey();
                entry.getValue()[0]--;
                prev++;
                for (int i = 1; i < k; i++) {
                    int[] ar = map.get(prev);
                    if (ar != null && ar[0] > 0) {
                        ar[0]--;
                        prev++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
