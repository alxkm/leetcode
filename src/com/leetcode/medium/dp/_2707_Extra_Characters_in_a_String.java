package com.leetcode.medium.dp;

import java.util.HashSet;
import java.util.Set;

public class _2707_Extra_Characters_in_a_String {
    //2707. Extra Characters in a String
    //https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-09-23
    //DP
    //ALMOST
    //NOT_MAIN

    Integer[] dp;
    Set<String> set = new HashSet<>();

    public int minExtraChar(String s, String[] dictionary) {
        for (var a: dictionary) set.add(a);
        dp = new Integer[s.length()];
        f(0, s);
        return dp[0];
    }

    public Integer f(int start, String s) {
        if (start == s.length()) return 0;
        if (dp[start] != null) return dp[start];

        int val = f(start + 1, s) + 1;
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (set.contains(str)) {
                val = Math.min(f(i + 1, s), val);
            }
        }
        return dp[start] = val;
    }
}
