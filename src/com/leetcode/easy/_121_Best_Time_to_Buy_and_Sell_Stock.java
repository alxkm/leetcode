package com.company;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else max = Math.max(prices[i] - min, max);
        }
        return max;
    }

    public static void main(String[] args) {
        /*
        Input: prices = [7,1,5,3,6,4]
        Output: 5

        Input: prices = [7,6,4,3,1]
        Output: 0
         */
    }
}
