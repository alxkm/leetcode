package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _216_Combination_Sum_III {
    //https://leetcode.com/problems/combination-sum-iii/
    //216. Combination Sum III

    private int k;
    private int n;
    private List<List<Integer>> ll = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) return ll;
        this.k = k;
        this.n = n;
        f(1, 0, new Stack<>());
        return ll;
    }

    private void f(int start, int s, Stack<Integer> st) {
        if (st.size() == k && s == n) {
            ll.add(new ArrayList<>(st));
            return;
        }

        if ((s + start) >  n) return;
        if (st.size() >= k) return;

        for (int i = start; i <= 9; i++) {
            st.add(i);
            f(i + 1, s + i, st);
            st.pop();
        }
    }

    public static void main(String[] args) {
        var sol = new _216_Combination_Sum_III();
        System.out.println(sol.combinationSum3(2, 18));
    }
}
