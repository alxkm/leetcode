package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _40_Combination_Sum_II {
    //https://leetcode.com/problems/combination-sum-ii/
    //40. Combination Sum II
    //https://leetcode.com/problems/combination-sum-ii/description/?envType=daily-question&envId=2024-08-13

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Set<Integer> set = new HashSet<>();
        for (int n: candidates) set.add(n);
        dfs(candidates, target, 0, ans, new ArrayList<>(), new HashSet<>(), set.size());
        return ans;
    }

    private void dfs(int[] candidates, int target, int i,
                     List<List<Integer>> ans, List<Integer> subAns, Set<String> set, int uniqSize) {
        if (target < 0) return;
        if (target == 0) {
            StringBuilder sb = new StringBuilder();
            for (int n: subAns) sb.append(n + "");
            if (set.contains(sb.toString())) return;
            set.add(sb.toString());

            ans.add(new ArrayList<>(subAns));
            return;
        }
        if (i >= candidates.length) return;
        if ((uniqSize == 1 || uniqSize == 2)
                && ans.size() == uniqSize) return;
        if (candidates[i] <= target) {
            subAns.add(candidates[i]);
            dfs(candidates,  target - candidates[i], i + 1, ans, subAns, set, uniqSize);
            subAns.remove(subAns.size() - 1);
        }
        dfs(candidates, target, i + 1, ans, subAns, set, uniqSize);
    }

    class Solution1 {
        private final List<List<Integer>> ans = new ArrayList<>();
        private final Set<String> set = new HashSet<>();
        private int uniqueSize;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            uniqueSize = Arrays.stream(candidates).boxed().collect(Collectors.toSet()).size();
            f(candidates, target, 0, new ArrayList<>());
            return ans;
        }

        private void f(int[] candidates, int target, int i, List<Integer> subList) {
            if (target < 0) return;
            if (target == 0) {
                StringBuilder sb = new StringBuilder();
                for (int n : subList) sb.append(n);
                if (set.contains(sb.toString())) return;
                set.add(sb.toString());
                ans.add(new ArrayList<>(subList));
                return;
            }
            if (i >= candidates.length || ((uniqueSize == 1 || uniqueSize == 2) && ans.size() == uniqueSize)) return;
            if (candidates[i] <= target) {
                subList.add(candidates[i]);
                f(candidates, target - candidates[i], i + 1, subList);
                subList.remove(subList.size() - 1);
            }
            f(candidates, target, i + 1, subList);
        }
    }
}
