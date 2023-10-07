package com.leetcode.top.permutation;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    //https://leetcode.com/problems/permutations/
    //FOREIGN_SOLUTION
    //backtrack
    //TOP

    private void f(int i, boolean[] used, int[] nums, int[] tempResult, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n: tempResult) {
                list.add(n);
            }
            result.add(list);
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!used[j]) {
                used[j] = true;
                tempResult[i] = nums[j];
                f(i + 1, used, nums, tempResult, result);
                used[j] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int[] temp = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        f(0, used, nums, temp, result);
        return result;
    }
}
