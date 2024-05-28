package com.leetcode.medium.slidingwindow;

public class _1208_Get_Equal_Substrings_Within_Budget {
    //1208. Get Equal Substrings Within Budget
    //https://leetcode.com/problems/get-equal-substrings-within-budget/description/

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int len = 0;
        int start = 0;
        int curCost = 0;

        for (int i = 0; i < n; i++) {
            curCost += Math.abs(s.charAt(i) - t.charAt(i));
            while (curCost > maxCost) {
                curCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;
    }
}
