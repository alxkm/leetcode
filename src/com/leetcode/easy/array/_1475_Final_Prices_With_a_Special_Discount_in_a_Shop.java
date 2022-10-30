package com.leetcode.easy.array;

import java.util.Arrays;

public class _1475_Final_Prices_With_a_Special_Discount_in_a_Shop {
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

    public static void main(String[] args) {
        int[] a = {8,4,6,2,3};

        System.out.println(Arrays.toString(finalPrices(a)));
    }
}
