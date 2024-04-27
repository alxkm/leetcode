package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _2870_Minimum_Number_of_Operations_to_Make_Array_Empty {
    //2870. Minimum Number of Operations to Make Array Empty
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int counter = 0;
        for (int v: map.values()) {
            if (v == 1) return -1;
            if (v > 10 && (v - 10) % 3 == 0) {
                counter += ((v - 10) / 3);
                counter += 4;
            } else if (v == 10) {
                counter += 4;
            } else if (v % 3 == 0) {
                counter += v / 3;
            } else if ((v - 2) % 3 == 0) {
                counter += 1;
                v -= 2;
                counter += v / 3;
            } else if ((v - 3) % 2 == 0) {
                counter += 1;
                v -= 3;
                counter += v / 2;
            } else if (v % 2 == 0) {
                counter += v / 2;
            } else {
                return -1;
            }
        }
        return counter;
    }

    public int minOperations1(int[] nums) {
        var counter = new HashMap<Integer, Integer>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int c: counter.values()) {
            if (c == 1) {
                return -1;
            }
            ans += Math.ceil((double) c / 3);
        }
        return ans;
    }
}
