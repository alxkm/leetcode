package com.leetcode.easy.math;

public class _2843_Count_Symmetric_Integers {
    //2843. Count Symmetric Integers
    //https://leetcode.com/problems/count-symmetric-integers/

    public int countSymmetricIntegers(int low, int high) {
        int c = 0;
        for (Integer i = low; i <= high; i++) {
            if (i.toString().length() % 2 == 0) {
                int s1 = 0, s2 = 0;
                char[] ch = i.toString().toCharArray();
                for (int j = 0, l = i.toString().length() / 2; l < i.toString().length(); j++, l++) {
                    s1 += ch[j];
                    s2 += ch[l];
                }
                if (s1 == s2) c++;
            }
        }
        return c;
    }
}
