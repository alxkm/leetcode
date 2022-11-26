package com.leetcode.easy.sort;

public class _2144_Minimum_Cost_of_Buying_Candies_With_Discount {
    public int minimumCost(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return cost[0] + cost[1];

        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < cost.length; i++) {
            firstMax = Math.max(firstMax, cost[i]);
        }
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] != firstMax)
                secondMax = Math.max(secondMax, cost[i]);
        }
        if (secondMax == 0) secondMax = firstMax;

        return secondMax + firstMax;
    }
}
