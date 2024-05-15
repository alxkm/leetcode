package com.leetcode.hard;

public class _1611_Minimum_One_Bit_Operations_to_Make_Integers_Zero {
    //1611. Minimum One Bit Operations to Make Integers Zero
    //https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/

    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int k = 0;
        while (Math.pow(2, k) <= n) k++;
        k -= 1;
        return (int)Math.pow(2, k + 1) - 1 - minimumOneBitOperations((int)Math.pow(2, k)^n);
    }
}
