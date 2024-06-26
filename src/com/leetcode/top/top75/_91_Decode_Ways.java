package com.leetcode.top.top75;

public class _91_Decode_Ways {
    //https://leetcode.com/problems/decode-ways/description/
    //91. Decode Ways
    //FOREIGN_SOLUTION
    //TOP

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(0) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }
            if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '0' && s.charAt(i + 1) < 7)) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    public int numDecodings1(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = 0;
            }

            if (i <= s.length() - 2 && ((s.charAt(i) == '1' && s.charAt(i + 1) <= '9') || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
