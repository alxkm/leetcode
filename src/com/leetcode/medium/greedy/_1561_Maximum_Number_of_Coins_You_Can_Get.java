package com.leetcode.medium.greedy;

import java.util.Arrays;

public class _1561_Maximum_Number_of_Coins_You_Can_Get {
    //1561. Maximum Number of Coins You Can Get
    //https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max = 0;
        boolean a = true;
        for (int i = piles.length - 1, j = 0; i > j; ) {
            i--;
            max += piles[i];
            i--;
            j++;
        }
        return max;
    }
}
