package com.leetcode.medium.monotonic;

import java.util.Stack;

public class _907_Sum_of_Subarray_Minimums {
    //907. Sum of Subarray Minimums
    //https://leetcode.com/problems/sum-of-subarray-minimums/
    //https://www.youtube.com/watch?v=Dq_ObZwTY_Q
    //https://liuzhenglaichn.gitbook.io/algorithm/monotonic-stack
    //foreign

    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        int sumOfMinimums = 0;

        for (int i = 0; i <= arr.length; i++) {
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int leftBoundary = st.empty() ? -1 : st.peek();
                int rightBoundary = i;

                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            st.push(i);
        }

        return sumOfMinimums;
    }
}
