package com.leetcode.top;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_Word_Break {
    //https://leetcode.com/problems/word-break/
    //139. Word Break
    //FOREIGN_SOLUTION
    //DP
    //TOP

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            for (int j = i + 1; j <= n; j++) {
                var str = s.substring(i, j);
                if (set.contains(str)) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
