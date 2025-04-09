package com.leetcode.easy.arrayarray;

public class _3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {
    //3396. Minimum Number of Operations to Make Elements in Array Distinct
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

    public int minimumOperations(int[] nums) {
        int[] ar = new int[101];
        for (int n: nums) ar[n]++;

        if (check(ar)) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i += 3) {
            for (int j = i; j < nums.length && j < i + 3; j++) {
                ar[nums[j]]--;
            }
            count++;
            if (check(ar)) return count;
        }
        return count;
    }

    private boolean check(int[] ar) {
        for (int n: ar) {
            if (n > 1) return false;
        }
        return true;
    }
}
