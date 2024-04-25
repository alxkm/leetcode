package com.leetcode.medium.bits;

public class _201_Bitwise_AND_of_Numbers_Range {
    //201. Bitwise AND of Numbers Range
    //https://leetcode.com/problems/bitwise-and-of-numbers-range/

    public int rangeBitwiseAnd(int left, int right) {
        int prefix = 0;

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;

            if ((left & mask) != (right & mask)) return prefix;

            prefix |=  (left & mask);
        }

        return prefix;
    }
}
