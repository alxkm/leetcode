package com.company.math;

public class _1837_Sum_of_Digits_in_Base_K {
    static public int sumBase(int n, int k) {
        int counter = 0;
        while (n > 0) {
            counter += n % k;
            n = n/k;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
    }
}
