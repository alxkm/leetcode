package com.leetcode.medium.dp;

public class _97_Interleaving_String {
    //https://leetcode.com/problems/interleaving-string/
    //TOP

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] check) {
        if (check[i][j]) return false;
        if (k == c3.length) return true;

        boolean checkOk =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, check) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, check);
        if (!checkOk) check[i][j] = true;
        return checkOk;
    }
}
