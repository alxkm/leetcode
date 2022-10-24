package com.leetcode.easy.gold.array;

public class _191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}
