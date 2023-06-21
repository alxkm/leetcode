package com.leetcode.easy.sort;

import java.util.Arrays;

public class _594_Longest_Harmonious_Subsequence {
    //https://leetcode.com/problems/longest-harmonious-subsequence/

    public int findLHS(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int counter = 1;
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (min == max || max == min + 1) {
                    counter++;
                    if (max == min + 1) answer = Math.max(answer, counter);
                } else {
                    break;
                }
            }

        }

        return answer;
    }
}
