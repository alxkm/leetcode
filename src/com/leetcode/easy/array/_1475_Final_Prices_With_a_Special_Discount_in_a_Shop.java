package com.leetcode.easy.array;

import java.util.Arrays;

public class _1475_Final_Prices_With_a_Special_Discount_in_a_Shop {
    //1475. Final Prices With a Special Discount in a Shop
    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=daily-question&envId=2024-12-18

    static public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            int discount = -1;
            int j = i + 1;
            while (j < prices.length) {
                if (prices[i] >= prices[j]) {
                    discount = prices[j];
                    break;
                }
                j++;
            }
            if (discount != -1) {
                prices[i] -= discount;
            }
        }
        return prices;
    }

    public int[] finalPrices1(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] a = {8,4,6,2,3};

        System.out.println(Arrays.toString(finalPrices(a)));
    }
}
