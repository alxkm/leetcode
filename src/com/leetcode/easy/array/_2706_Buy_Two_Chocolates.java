package com.leetcode.easy.array;

public class _2706_Buy_Two_Chocolates {
    //2706. Buy Two Chocolates
    //https://leetcode.com/problems/buy-two-chocolates/description/

    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min1 = Math.min(min1, prices[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == min1) {
                prices[i] = Integer.MAX_VALUE;
                break;
            }
        }
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min2 = Math.min(min2, prices[i]);
        }
        if (min1 + min2 > money) {
            return money;
        }
        return money - min1 - min2;
    }
}
