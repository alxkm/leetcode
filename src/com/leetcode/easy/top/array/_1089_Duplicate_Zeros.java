package com.leetcode.easy.top.array;

import java.util.Arrays;

public class _1089_Duplicate_Zeros {
    static public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (arr.length > i + 1) {
                    int prev = arr[i + 1];
                    arr[i + 1] = 0;
                    if (arr.length > i + 2) {
                        for (int j = i + 2; j < arr.length; j++) {
                            int temp = arr[j];
                            arr[j] = prev;
                            prev = temp;
                        }
                    }
                    i += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9,0,2,0};
        duplicateZeros(a);
        System.out.println(Arrays.toString(a));
    }
}
