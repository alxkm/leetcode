package com.leetcode.easy.greedly;

public class _1827_Minimum_Operations_to_Make_the_Array_Increasing {
    //1827. Minimum Operations to Make the Array Increasing
    //https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

    public int minOperations(int[] nums) {
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int a = ((nums[i - 1] - nums[i]) + 1);
                answer += a;
                nums[i] += a;
            }
        }
        return answer;
    }
}
