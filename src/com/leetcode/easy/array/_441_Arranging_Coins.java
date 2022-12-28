package com.leetcode.easy.array;

public class _441_Arranging_Coins {
    public int arrangeCoins(int n) {
        int q = 0;
        int i = 1;
        while (true) {
            if (n - i >= 0) {
                q++;
                n -= i;
                i++;
                continue;
            }
            break;
        }
        return q;
    }
}
