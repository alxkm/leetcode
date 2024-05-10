package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _907_Sum_of_Subarray_Minimums {
    //907. Sum of Subarray Minimums
    //https://leetcode.com/problems/sum-of-subarray-minimums/
    int s = 0;
    public int sumSubarrayMins(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            f(i, arr, arr[i]);
        }
        return s;
    }

    private void f(int i, int[] arr, int min) {
        if (i >= arr.length - 1) {
            s += min % 1_000_000_007;
        }
        f(i + 1, arr, Math.min(min, arr[i + 1]));
    }

    public static void main(String[] args) {
        int [] arr = new int[]{3, 1, 2, 4};
        int s = 0;
        int n = arr.length;
        int[] st = new int[n];
        Arrays.fill(st, Integer.MAX_VALUE);
        st[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            st[i] = Math.min(arr[i], st[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            s += ((arr[i] + st[i] * (n - i)) % 1_000_000_007);
            s %= 1_000_000_007;
        }


        var sol = new _907_Sum_of_Subarray_Minimums();
        System.out.println(sol.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
    public int sumSubarrayMins2(int[] arr) {
        int s = 0;
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < st.get(st.size() - 1)[1]) {
                int[] min = st.pop();
                int j = min[0];
                int m = min[1];
                int left = (!st.isEmpty()) ? j - st.get(st.size() - 1)[0] : j + 1;
                int right = i - j;
                s = (s + m * left * right) % 1_000_000_007;
            }
            st.add(new int[]{i, arr[i]});
        }

        List<int[]> stl = new ArrayList<>(st);
        for (int i = 0; i < stl.size(); i++) {
            int j = stl.get(i)[0];
            int m = stl.get(i)[1];
            int left = (i > 0) ? j - stl.get(i - 1)[0] : j + 1;
            int right = m - j;
            s = (s + m * left * right) % 1_000_000_007;
        }
        return s;
    }
    /*

    public int sumSubarrayMins(int[] arr) {
        List<List<Integer>> ll = new ArrayList<>();
        f(-1, arr, new Stack<>(), ll);
        int s = 0;
        for (var l: ll) {
            int min = Integer.MAX_VALUE;
            for (int v: l) {
                min = Math.min(min, v);
            }
            s += min % 1_000_000_007;
        }
        return s;
    }

    private void f(int i, int[] arr, Stack<Integer> st, List<List<Integer>> ll) {
        if (i >= arr.length) return;

        if (!st.isEmpty()) ll.add(new ArrayList<>(st));

        for (int j = i + 1; j < arr.length; j++) {
            st.add(arr[j]);
            f(j, arr, st, ll);
            st.pop();
        }
    }
    * */
}
