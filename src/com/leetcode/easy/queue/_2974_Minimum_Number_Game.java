package com.leetcode.easy.queue;

import java.util.Arrays;

public class _2974_Minimum_Number_Game {
    //2974. Minimum Number Game
    //https://leetcode.com/problems/minimum-number-game/description/

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
        return nums;
    }
}
