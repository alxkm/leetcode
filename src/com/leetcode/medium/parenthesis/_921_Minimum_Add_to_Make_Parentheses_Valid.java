package com.leetcode.medium.parenthesis;

public class _921_Minimum_Add_to_Make_Parentheses_Valid {
    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    //921. Minimum Add to Make Parentheses Valid

    public int minAddToMakeValid(String s) {
        int op = 0;
        int cl = 0;
        char[] ch = s.toCharArray();
        int total = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                op++;
            } else {
                cl++;
                if (op == cl) {
                    op--;
                    cl--;
                } else if (cl > op) {
                    total++;
                    cl--;
                }
            }
        }
        return Math.abs(op - cl) + total;
    }
}
