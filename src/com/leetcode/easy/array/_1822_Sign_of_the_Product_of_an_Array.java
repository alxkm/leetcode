package com.leetcode.easy.array;

public class _1822_Sign_of_the_Product_of_an_Array {
    public int arraySign(int[] nums) {
        int counter = 0;
        boolean is = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) counter++;
            if (nums[i] == 0) is = true;
        }
        if (is) return 0;

        if (counter % 2 != 0) return -1;

        return 1;
    }
}
