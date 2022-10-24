package com.leetcode.easy.math;

public class _367_Valid_Perfect_Square {
    static public boolean isPerfectSquare(int num) {

        long a = 1;
        long b = 0;
//        while (a * a <= num) {
//            b = a;
//            a += 1;
//        }

        long i = 1;
        while (i * i <= num) {
            i ++;
        }

        //return b * b == num;
        return i * i == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
        //System.out.println(isPerfectSquare(2147483647));
    }
}
