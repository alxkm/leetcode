package com.leetcode.easy.array;

public class _1995_Count_Special_Quadruplets {
    //1995. Count Special Quadruplets
    //https://leetcode.com/problems/count-special-quadruplets/description/

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int d = nums.length - 1; d >= 3; d--) {
            for (int c = d - 1; c >= 2; c--) {
                for (int b = c - 1; b >= 1; b--) {
                    for (int a = b - 1; a >= 0; a--) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int countQuadruplets1(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[1000];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) cnt[nums[d] - nums[b + 1] + 200]++;
            for (int a = 0; a < b; a++) ans += cnt[nums[a] + nums[b] + 200];
        }
        return ans;
    }
}
