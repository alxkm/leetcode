package com.leetcode.medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2370_Longest_Ideal_Subsequence {
    //2370. Longest Ideal Subsequence
    //https://leetcode.com/problems/longest-ideal-subsequence/description/
    int k;
    char[] s;
    int n;
    int[][] dp;
    Map<String, Integer> map = new HashMap<>();

    public int longestIdealString(String s, int k) {
        this.k = k;
        this.s = s.toCharArray();
        n = s.length();
        dp = new int[n][26];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int max = 0;
        for (int c = 0; c < 26; c++) {
            max = Math.max(max, dfs(n - 1, c));
        }
        return max;
    }
    private int dfs(int i, int c) {
        if (dp[i][c] != -1) return dp[i][c];

        dp[i][c] = 0;
        boolean notVisitedMatch = c == (s[i] - 'a');
        if (notVisitedMatch) dp[i][c] = 1;

        if (i > 0) {
            dp[i][c] = dfs(i - 1, c);
            if (notVisitedMatch) {
                for (int p = 0; p < 26; p++) {
                    if (Math.abs(c - p) <= k) {
                        dp[i][c] = Math.max(dp[i][c], dfs(i - 1, p) + 1);
                    }
                }
            }
        }

        return dp[i][c];
    }

    private int f(int i, int j) {
        if (j == s.length) return 0;
        String key = i + "," + j;
        Integer max = map.get(key);
        if (max != null) return max;
        max = 0;
        if (s[i] != s[j]) max = f(i, j + 1);
        if (Math.abs(s[i] - s[j]) <= k)  max = Math.max(max, f(j, j + 1) + 1);
        map.put(key, max);

        return max;
    }

    public static void main(String[] args) {
        var sol = new _2370_Longest_Ideal_Subsequence();
        System.out.println(sol.longestIdealString("acfgbd", 2));
        System.out.println(sol.longestIdealString("abcd", 3));
        System.out.println(sol.longestIdealString("dyyonfvzsretqxucmavxegvlnnjubqnwrhwikmnnrpzdovjxqdsatwzpdjdsneyqvtvorlwbkb", 7));
    }

}
