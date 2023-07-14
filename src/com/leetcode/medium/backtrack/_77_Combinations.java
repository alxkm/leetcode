package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _77_Combinations {
    //https://leetcode.com/problems/combinations/

    private int[] arr;
    private boolean[] used;
    private int length;

    public List<List<Integer>> combine(int n, int k) {
        arr = new int[n];
        length = k;
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> list = new ArrayList<>();
        f(list, 0, new Stack<Integer>());
        return list;
    }

    private void f(List<List<Integer>> list, int ii, Stack<Integer> stack) {
        if (stack.size() == length) {
            list.add(new ArrayList<>(stack));
            return;
        }

        for (int i = ii; i < arr.length; i++) {
            if (!used[i]) {
                stack.add(arr[i]);
                used[i] = true;
                f(list, i + 1, stack);
                used[i] = false;
                stack.pop();
            }
        }
    }
}
