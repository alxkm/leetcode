package com.leetcode.medium.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _377_Combination_Sum_IV {
    //377. Combination Sum IV
    //https://leetcode.com/problems/combination-sum-iv/
    //TOP
    //todo todo todo

    public int combinationSum4(int[] nums, int target) {
        return f (nums, target, new HashMap<>());
    }

    public int f(int[] nums, int target, Map<Integer, Integer> dp) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (dp.containsKey(target)) return dp.get(target);

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += f (nums, target - nums[i], dp);
        }
        dp.put(target, counter);
        return counter;
    }

    //TL
    public int combinationSum4_(int[] nums, int target) {
        Arrays.sort(nums);
        int[] counter = new int[1];
        f_(0, 0, target, nums, counter);
        return counter[0];
    }

    public void f_(int start, int sum, int target, int[] nums, int[] counter) {
        if (sum == target) {
            counter[0]++;
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) break;
            f_(0, sum + nums[i], target, nums, counter);
        }
    }
}
