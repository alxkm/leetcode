package com.leetcode.medium.bits;

public class _2997_Minimum_Number_of_Operations_to_Make_Array_XOR_Equal_to_K {
    //2997. Minimum Number of Operations to Make Array XOR Equal to K
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/

    public int minOperations(int[] nums, int k) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        int counter = 0;
        while (k > 0 || n > 0) {
            if ((k % 2) != (n % 2)) counter++;
            k /= 2;
            n /= 2;
        }
        return counter;
    }
}
