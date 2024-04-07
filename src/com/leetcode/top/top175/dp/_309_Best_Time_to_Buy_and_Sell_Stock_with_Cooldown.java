package com.leetcode.top.top175.dp;

public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    //309. Best Time to Buy and Sell Stock with Cooldown
    //FOREIGN_SOLUTION
    //TOP

    public int maxProfit(int[] prices) {
        int price1 = -prices[0], price2 = 0, price3 = 0;
        for (int i = 1; i < prices.length; ++i) {
            int profit1 = price1, profit2 = price2, profit3 = price3;
            price1 = Math.max(profit1, profit3 - prices[i]);
            price2 = Math.max(price2, profit1 + prices[i]);
            price3 = Math.max(profit3, profit2);
        }
        return price2;
    }
}
