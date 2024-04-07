package com.leetcode.top.top175;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _437_Path_Sum_III {
    //https://leetcode.com/problems/path-sum-iii/
    //437. Path Sum III
    //todo todo todo

    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        dfs(root, 0, targetSum, prefixSumMap);
        return result;
    }

    private void dfs(TreeNode t, long curSum, long targetSum, Map<Long, Integer> prefixSumMap) {
        if (t == null) return;

        curSum += t.val;
        if (curSum == targetSum) {
            result++;
        }
        result += prefixSumMap.getOrDefault(curSum - targetSum, 0);

        prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        dfs(t.left, curSum, targetSum, prefixSumMap);
        dfs(t.right, curSum, targetSum, prefixSumMap);

        prefixSumMap.put(curSum, prefixSumMap.get(curSum) - 1);
    }
}
