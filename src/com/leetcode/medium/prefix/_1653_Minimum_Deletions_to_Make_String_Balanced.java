package com.leetcode.medium.prefix;

public class _1653_Minimum_Deletions_to_Make_String_Balanced {
    //1653. Minimum Deletions to Make String Balanced
    //https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30

    public int minimumDeletions(String s) {
        int[] b = new int[s.length()];
        int[] a = new int[s.length()];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            b[i] = total;
            if (s.charAt(i) == 'b') total++;
        }
        total = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            a[i] = total;
            if (s.charAt(i) == 'a') total++;
        }

        int minDeletions = s.length();
        for (int i = 0; i < s.length(); i++) {
            minDeletions = Math.min(minDeletions, a[i] + b[i]);
        }
        return minDeletions;
    }
}
