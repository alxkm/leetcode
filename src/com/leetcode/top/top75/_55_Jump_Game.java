package com.leetcode.top.top75;

public class _55_Jump_Game {
    //https://leetcode.com/problems/jump-game/

    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int v, boolean[] visit) {
        if (v >= nums.length) return true;
        if (visit[v]) return false;
        visit[v] = true;

        for (int i = 1; i <= nums[v]; i++) {
            if (dfs(nums, i, visit)) return true;
        }
        return false;
    }
}
