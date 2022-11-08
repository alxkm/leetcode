package com.leetcode.easy.sort;

import java.util.Arrays;

public class _1619_Mean_of_Array_After_Removing_Some_Elements {
    static public double trimMean(int[] arr) {
        double q = ((double) arr.length / 100) * 5;
        Arrays.sort(arr);
        int from = (int)q;
        int to = arr.length - (int)q;
        System.out.println(to);
        System.out.println(q);
        double sum = 0;
        for (int i = from; i < to; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};

        System.out.println(trimMean(arr));
    }
}
