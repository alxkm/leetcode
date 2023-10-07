package com.leetcode.medium.stack;

import java.util.Stack;

public class _456_132_Pattern {
    //https://leetcode.com/problems/132-pattern/
    //TOP

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> st = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!st.isEmpty() && st.peek() <= min[j]) {
                    st.pop();
                }

                if (!st.isEmpty() && st.peek() < nums[j]) {
                    return true;
                }

                st.push(nums[j]);
            }
        }

        return false;
    }
}
