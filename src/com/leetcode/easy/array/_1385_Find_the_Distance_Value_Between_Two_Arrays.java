package com.leetcode.easy.array;

public class _1385_Find_the_Distance_Value_Between_Two_Arrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int counter = 0;
        for (int x : arr1) {
            boolean is = false;
            for (int y : arr2) {
                if (Math.abs(x - y) <= d) {
                    is = true;
                    break;
                }
            }
            if (!is) counter++;
        }
        return counter;
    }
}
