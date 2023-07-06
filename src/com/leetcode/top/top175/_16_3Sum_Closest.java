package com.leetcode.top.top175;

public class _16_3Sum_Closest {
    //https://leetcode.com/problems/3sum-closest/

    public int threeSumClosest(int[] nums, int target) {
        int answer = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k] - target) < (prev - target)) {
                        answer = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return answer;
    }
}
