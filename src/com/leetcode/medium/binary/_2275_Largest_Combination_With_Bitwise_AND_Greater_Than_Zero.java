package com.leetcode.medium.binary;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {
    //2275. Largest Combination With Bitwise AND Greater Than Zero
    //https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/

    public static int largestCombination(int[] candidates) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        for (int n : candidates) {
            int i = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(n);
                    max = Math.max(max, map.get(i).size());
                }
                n /= 2;
                i++;
            }
        }
        return max;
    }

    public int largestCombination1(int[] candidates) {
        int[] map = new int[32];
        int max = 0;
        for (int n : candidates) {
            int i = 0;
            while (n > 0) {
                map[i] += 1 & n;
                n = n >> 1;
                if (max < map[i]) max = map[i];
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestCombination(ArrayUtil.of(8, 8)));
    }
}
