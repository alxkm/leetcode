package com.leetcode.medium.string;

public class _516_Longest_Palindromic_Subsequence {
    //https://leetcode.com/problems/longest-palindromic-subsequence/

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return lcs(s.toCharArray(), sb.toString().toCharArray());
    }

    private int lcs(char[] s, char[] ss) {
        int[][] temp = new int[s.length + 1][ss.length + 1];
        int max = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                if (s[i - 1] == ss[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
                if (temp[i][j] > max) max = temp[i][j];
            }
        }
        return max;
    }
}
