package com.leetcode.binarysearch;

import java.util.Arrays;

public class _2226_Maximum_Candies_Allocated_to_K_Children {
    //2226. Maximum Candies Allocated to K Children
    //https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/

    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = Arrays.stream(candies).max().getAsInt();
        while (left < right) {
            int middle = (left + right + 1) / 2;

            if (canAllocateCandies(candies, k, middle)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    private boolean canAllocateCandies(int[] candies, long k, int numOfCandies) {
        long maxNumOfChildren = 0;

        for (int pileIndex = 0; pileIndex < candies.length; pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }
}
