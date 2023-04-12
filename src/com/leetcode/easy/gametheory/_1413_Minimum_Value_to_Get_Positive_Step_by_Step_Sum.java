package com.leetcode.easy.gametheory;

public class _1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
    //https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
    //1413. Minimum Value to Get Positive Step by Step Sum

    public int minStartValue(int[] nums) {
        for (int n = 1; ; n++) {
            boolean allAre = true;
            int s = n;
            for (int a : nums) {
                s += a;
                if (s < 1) {
                    allAre = false;
                    break;
                }
            }
            if (allAre) {
                return n;
            }
        }
    }
}
