package com.leetcode.easy.array;

public class _941_Valid_Mountain_Array {
    //941. Valid Mountain Array
    //https://leetcode.com/problems/valid-mountain-array/

    public boolean validMountainArray(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i])  max = i;
        }

        if (max == 0 || max == arr.length - 1) return false;

        for (int i = max - 1; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        for (int i = max + 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) return false;
        }

        return true;
    }
}
