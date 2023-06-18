package com.leetcode.easy.array;

public class _2574_Left_and_Right_Sum_Differences {
    //https://leetcode.com/problems/left-and-right-sum-differences/

    public int[] leftRigthDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 0;
        right[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] + left[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(left[i] - right[i]);
        }
        return answer;
    }
}
