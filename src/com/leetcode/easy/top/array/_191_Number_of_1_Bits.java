package com.leetcode.easy.top.array;

public class _191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    //191. Number of 1 Bits
    //https://leetcode.com/problems/number-of-1-bits/description/

    public int hammingWeight(int n) {
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
        }
        return cnt;
    }

    public int hammingWeight1(int n) {
        int q = 0;

        if (n < 0) {
            n = ~n;
            while (n > 0) {
                q += n % 2;
                n /= 2;
            }
            return 32 - q;
        }

        while (n > 0) {
            q += n % 2;
            n /= 2;
        }

        return q;
    }
}
