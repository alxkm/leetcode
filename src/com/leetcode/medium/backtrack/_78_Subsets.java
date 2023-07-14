package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _78_Subsets {
    //https://leetcode.com/problems/subsets/

    private Stack<Integer> stack;
    private List<List<Integer>> list;

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        f(nums, list, new Stack<Integer>(), 0);
        return list;
    }

    private void f(
            int[] n, List<List<Integer>> r,
            Stack<Integer> stack, int start) {

        r.add(new ArrayList<>(stack));
        System.out.println(stack);
        if (start == n.length) return;

        for (int j = start; j < n.length; j++) {
            stack.push(n[j]);
            f(n, r, stack, start + 1);
            stack.pop();
        }
    }
}
