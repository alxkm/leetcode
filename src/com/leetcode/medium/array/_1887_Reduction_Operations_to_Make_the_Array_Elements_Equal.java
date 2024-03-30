package com.leetcode.medium.array;

public class _1887_Reduction_Operations_to_Make_the_Array_Elements_Equal {
    //https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
    //1887. Reduction Operations to Make the Array Elements Equal

    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
            }
        }
        return res;
    }
}
