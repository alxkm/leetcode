package com.leetcode.medium.array;

public class _2498_Frog_Jump_II {
    //https://leetcode.com/problems/frog-jump-ii/

    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n == 2) return stones[n - 1];
        int minCost = 0;
        for (int i = 0; i < stones.length - 2; i++) {
            minCost = Math.max(minCost, stones[i + 2] - stones[i]);
        }
        return minCost;
    }
}
