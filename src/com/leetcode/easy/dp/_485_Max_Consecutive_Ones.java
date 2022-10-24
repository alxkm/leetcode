package com.company.dp;

public class _485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;

        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        max = Math.max(max, cnt);
        return max;
    }
}
