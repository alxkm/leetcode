package com.leetcode.easy;

public class _69_Sqrt_x_ {

    static public int mySqrt(int x) {
        long l = 0;
        long r = 10000;
        long b = 0;
        while (b * b <= x) {
            b = (l + (r - l)) / 2;
            if (b * b < x) {
                l = b;
            } else {
                r = b   ;
            }
        }
        return (int) b;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
