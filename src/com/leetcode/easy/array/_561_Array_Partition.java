package com.leetcode.easy.array;

public class _561_Array_Partition {
    public int sumOddLengthSubarrays(int[] arr) {
        int counter = 0;
        for (int i = 1; i <= arr.length; i+=2) {
            for (int j = 0; j <= arr.length - i; j++){
                for (int k = 1, l = j; k <= i; k++, l++) {
                    counter += arr[l];
                }
            }
        }
        return counter;
    }
}
