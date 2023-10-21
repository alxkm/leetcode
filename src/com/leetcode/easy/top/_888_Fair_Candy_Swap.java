package com.leetcode.easy.top;

import java.util.HashSet;
import java.util.Set;

public class _888_Fair_Candy_Swap {
    //https://leetcode.com/problems/fair-candy-swap/
    //888. Fair Candy Swap

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a: aliceSizes) {
            sumA += a;
        }

        Set<Integer> setB = new HashSet<>();
        for (int b: bobSizes) {
            sumB += b;
            setB.add(b);
        }
        int delta = (sumB - sumA) / 2;
        for (int a: aliceSizes) {
            if (setB.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }

        return null;
    }
}
