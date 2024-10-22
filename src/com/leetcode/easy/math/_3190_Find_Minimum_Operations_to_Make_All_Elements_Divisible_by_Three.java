package com.leetcode.easy.math;

public class _3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {
    //https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
    //3190. Find Minimum Operations to Make All Elements Divisible by Three

    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int n: nums) {
            if (n % 3 != 0) count++;
        }
        return count;
    }
}
