package com.leetcode.easy.math;

public class _1952_Three_Divisors {
    static public boolean isThree(int n) {
        if (n <= 3) return false;
        int i = 2;
        int counter = 2;
        while (i <= (n / 2)){
            if (n % i == 0) {
                counter++;
                if (counter > 3) return false;
            }
            i++;
        }
        return counter == 3;
    }

    public static void main(String[] args) {
        System.out.println(isThree(14));
    }
}
