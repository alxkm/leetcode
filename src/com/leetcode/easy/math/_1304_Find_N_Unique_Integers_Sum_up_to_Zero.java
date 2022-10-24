package com.company.math;

import java.util.Arrays;

public class _1304_Find_N_Unique_Integers_Sum_up_to_Zero {
    static     public int[] sumZero(int n) {
        if (n < 1) {
            int[] b = {0};
            return b;
        }
        int[] a = new int[n];
        int size = n;
        if (n % 2 != 0) {
            size = n - 1;
        }
        int j = 1;
        for (int i = 0; i < size; i++) {
            a[i] = j;
            a[++i] = -j;
            j++;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(1)));
    }
}
