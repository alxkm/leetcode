package com.leetcode.medium.dp;

public class _45_Jump_Game_II {
    //https://leetcode.com/problems/jump-game-ii/

    public int jump(int[] nums) {
        int d = 0, l = 0, r = 0;
        while (r < nums.length - 1) {
            int max = 0;
            for (int i = l; i < r + 1; i++) {
                max = Math.max(i + nums[i], max);
            }
            l = r + 1;
            r = max;
            d++;
        }
        return d;
    }

    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];

        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((i + 1 + nums[i]) >= nums.length) {
                dp[i] = 1;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                if (dp[i + j] == 0) continue;
                min = Math.min(dp[i + j], min);
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = 0;
            } else {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        var sol = new _45_Jump_Game_II();
        sol.jump(new int[] {2,3,0,1,4});
    }
}
