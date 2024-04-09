package com.leetcode.top.top175;

import java.util.Arrays;

public class _16_3Sum_Closest {
    //https://leetcode.com/problems/3sum-closest/
    //16. 3Sum Closest

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

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                curSum = nums[i] + nums[left] + nums[right];
                if (curSum == target) return curSum;

                if (Math.abs(curSum - target) < Math.abs(sum - target)) sum = curSum;

                if (curSum <= target) {
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                } else {
                    right--;
                }
            }
        }
        return sum;
    }
}
