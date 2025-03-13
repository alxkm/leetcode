package com.leetcode.hard;

public class _1092_Shortest_Common_Supersequence {
    //1092. Shortest Common Supersequence
    //https://leetcode.com/problems/shortest-common-supersequence/description/?envType=daily-question&envId=2025-02-28
    //dp

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        // When str2 is empty, the supersequence is str1 itself (length = row index)
        for (int row = 0; row <= m; row++) {
            dp[row][0] = row;
        }
        // When str1 is empty, the supersequence is str2 itself (length = col index)
        for (int col = 0; col <= n; col++) {
            dp[0][col] = col;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append any remaining characters
        // If there are leftover characters in str1
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        // If there are leftover characters in str2
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
}
