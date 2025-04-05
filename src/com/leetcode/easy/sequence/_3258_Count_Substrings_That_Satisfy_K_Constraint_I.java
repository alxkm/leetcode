package com.leetcode.easy.sequence;

public class _3258_Count_Substrings_That_Satisfy_K_Constraint_I {
    //3258. Count Substrings That Satisfy K-Constraint I
    //https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/

    public int countKConstraintSubstrings(String s, int k) {
        char[] ch = s.toCharArray();
        int counter = 0;
        for (int i = 0; i < ch.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < ch.length; j++) {
                if (ch[j] == '1') one++;
                else zero++;

                if (one <= k || zero <= k) counter++;
                else break;
            }
        }
        return counter;
    }
}
