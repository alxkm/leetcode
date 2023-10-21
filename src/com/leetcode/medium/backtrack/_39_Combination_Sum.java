package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

public class _39_Combination_Sum {
    //https://leetcode.com/problems/combination-sum/
    //39. Combination Sum

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] candidates, int target, int i,
                     List<List<Integer>> ans, List<Integer> subAns) {
        if (target == 0) {
            ans.add(new ArrayList<>(subAns));
            return;
        }
        if (i >= candidates.length) return;

        if (candidates[i] <= target) {
            subAns.add(candidates[i]);
            dfs(candidates,  target - candidates[i], i, ans, subAns);
            subAns.remove(subAns.size() - 1);
        }
        dfs(candidates, target, i + 1, ans, subAns);
    }
}
