package com.leetcode.easy.array;

public class _1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
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
