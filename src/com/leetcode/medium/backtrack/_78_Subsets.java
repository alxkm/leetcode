package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _78_Subsets {
    //https://leetcode.com/problems/subsets/description/
    //78. Subsets

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

    class Solution {
        List<List<Integer>> ll = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            f(0, nums, new Stack<>());
            return ll;
        }

        void f(int i, int[] nums, Stack<Integer> st) {
            if (i == nums.length) {
                ll.add(new ArrayList<>(st));
                return;
            }
            st.add(nums[i]);
            f(i + 1, nums, st);
            st.pop();
            f(i + 1, nums, st);
        }
    }
}
