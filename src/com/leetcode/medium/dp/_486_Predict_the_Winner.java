package com.leetcode.medium.dp;

import java.util.HashMap;
import java.util.Map;

public class _486_Predict_the_Winner {
    //486. Predict the Winner
    //https://leetcode.com/problems/predict-the-winner/description/

    private Map<String, Integer> map = new HashMap<>();
    private int[] nums;

    public boolean predictTheWinner(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return true;
        this.nums = nums;
        int totalScore = 0;
        for (int n : nums) totalScore += n;
        int sc1 = f(0, nums.length - 1);
        int sc2 = totalScore - sc1;
        return sc1 >= sc2;
    }

    private int f(int i, int j) {
        if (i > j) return 0;
        String key = i + "," + j;
        var val = map.get(key);
        if (val != null) return val;

        int ns1 = nums[i] + Math.min(f(i + 2, j), f(i + 1, j - 1));
        int ns2 = nums[j] + Math.min(f(i + 1, j - 1), f(i, j - 2));
        val = Math.max(ns1, ns2);
        map.put(key, val);
        return val;
    }
}
