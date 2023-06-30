package com.leetcode.medium.array;

import java.util.Arrays;

public class _2221_Find_Triangular_Sum_of_an_Array {
    //https://leetcode.com/problems/find-triangular-sum-of-an-array/

    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < n - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
                System.out.println(" j " + j);
                System.out.println("nums j " + nums[j]);
                System.out.println("nums n " + n);
            }
            System.out.println(n);
            if (n > 1)
                nums[n - 1] = -1;
            n--;
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }

    public static void main(String[] args) {
        var solution = new _2221_Find_Triangular_Sum_of_an_Array();
        int[] a = {0,3,3,4,1,2,6,4,9,3,5,1,7,7,3,0,3,2,5,1,9,0,2,6,3,9,2,5,9,2,6,4,2,9,7,2,0,3,0,1,1,2,7,8,6,4,4,5};
        solution.triangularSum(a);
    }
}
