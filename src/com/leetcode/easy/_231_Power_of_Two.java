package com.company;

public class _231_Power_of_Two {
    static public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        if (n == 0) return false;
        if (n == 1) return true;
        if (n == 2) return true;
        while (true) {
            if (n % 2 != 0) return false;
            n = n / 2;
            if (n == 1) return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
