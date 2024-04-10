package com.leetcode.hard;

public class _1531_String_Compression_II_3 {
    //1531. String Compression II
    //https://leetcode.com/problems/string-compression-ii/

    private int[][][][] dp;
    private char[] s;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s.toCharArray();
        int n = s.length() + 1;
        dp = new int[n + 1][k + 1][26][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < 26; l++) {
                    for (int m = 0; m < n; m++) {
                        dp[i][j][l][m] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return f(0, k, '_', 0);
    }

    private int f(int i, int k, char prev, int prevCnt) {

        int cachedVal = (prev == '_') ? Integer.MAX_VALUE : dp[i][k][prev - 'a'][prevCnt];
        if (cachedVal != Integer.MAX_VALUE) return cachedVal;

        if (k < 0) return Integer.MAX_VALUE;
        if (i == s.length) return 0;

        if (s[i] == prev) {
            int increment = (prevCnt == 1 || prevCnt == 9 || prevCnt == 99) ? 1 : 0;
            cachedVal = increment + f(i + 1, k, prev, prevCnt + 1);
        } else {
            cachedVal = Math.min(
                    f(i + 1, k - 1, prev, prevCnt),
                    1 + f(i + 1, k, s[i], 1)
            );
        }

        dp[i][k][prev][prevCnt] = cachedVal;
        return cachedVal;
    }

    public static void main(String[] args) {
        var sol = new _1531_String_Compression_II_3();
        System.out.println(sol.getLengthOfOptimalCompression("aaaaaaaaaa", 2));
    }
}
