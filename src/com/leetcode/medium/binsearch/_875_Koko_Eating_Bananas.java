package com.leetcode.medium.binsearch;

import java.util.Arrays;

public class _875_Koko_Eating_Bananas {
    //https://leetcode.com/problems/koko-eating-bananas/
    //875. Koko Eating Bananas
    //Aug 01, 2023 12:53
    //FOREIGN_SOLUTIONS

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int min = r;

        while (l < r + 1) {
            int k = (l + r) / 2;
            int hours = 0;
            for (int n: piles) {
                hours += Math.ceil((double) n/k);
            }

            if (hours <= h) {
                min = Math.min(min, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return min;
    }
}
