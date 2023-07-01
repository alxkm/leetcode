package com.leetcode.medium.dp;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    //todo todo todo

    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                profit += prices[i] - max;
            }
            max = prices[i];
        }

        return profit;
    }
}
