package com.leetcode.easy.bit;

public class _190_Reverse_Bits {
    //https://leetcode.com/problems/reverse-bits/description/
    //190. Reverse Bits

    public int reverseBits(int n) {
        int a = 0;
        int cur = 0;
        for (int i = 0; i <= 32; i++) {
            cur = (int)Math.pow(2, i);
            int c = n & cur;
            System.out.println(Integer.toBinaryString(cur));
            System.out.println(Integer.toBinaryString(c));
            if (c == 0) {
                //this bit was 0
                //must be 1
                a += cur;
            }
            System.out.println("cur " + Integer.toBinaryString(a));
        }

        a *= -1;
        return a;

    }

    public static void main(String[] args) {
        var sol = new _190_Reverse_Bits();
        sol.reverseBits( Integer.parseInt("00000010100101000001111010011100", 2));
    }
}
