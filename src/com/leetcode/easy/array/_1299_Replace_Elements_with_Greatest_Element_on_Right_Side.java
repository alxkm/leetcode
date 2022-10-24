package com.leetcode.easy.array;

public class _1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int prev = max;
            max = Math.max(arr[i], max);
            arr[i] = prev;
        }

        arr[arr.length - 1] = -1;
        return arr;
    }
}
