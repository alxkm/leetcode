package com.company.array;

import java.util.Arrays;

public class _1470_Shuffle_the_Array {
    static public int[] shuffle(int[] nums, int n) {
        int[] a = new int[n*2];
        for (int i = 0, j = 0; j < n; i++, j++) {
            a[i] = nums[j];
            int b = nums[n + j];
            a[++i] = b;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] b = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(b, 3)));
    }
}
