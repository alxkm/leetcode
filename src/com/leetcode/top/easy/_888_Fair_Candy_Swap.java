package com.leetcode.top.easy;

import java.util.HashSet;
import java.util.Set;

public class _888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = 0, sum2 = 0;
        for (int a: aliceSizes) {
            sum1 += a;
        }

        //Set<Integer> setB = new HashSet<>();
        for (int b: bobSizes) {
            sum2 += b;
            //setB.add(b);
        }
        int[] answer = new int[2];

        for (int a: aliceSizes) {
            for (int b: bobSizes) {
                if ((sum1 - a + b) == (sum2 - b + a)) {
                    answer = new int[]{a, b};
                    break;
                }
            }
        }

        return answer;
    }

    public int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a: aliceSizes) {
            sumA += a;
        }

        Set<Integer> setB = new HashSet<>();
        for (int b: bobSizes) {
            sumB += b;
            setB.add(b);
        }
        int[] answer = new int[2];
        int delta = (sumB - sumA) / 2;
        for (int a: aliceSizes) {
            if (setB.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }

        return null;
    }
}
