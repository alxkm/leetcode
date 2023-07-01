package com.leetcode.medium.math;

public class _2575_Find_the_Divisibility_Array_of_a_String {
    //https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

    public int[] divisibilityArray(String word, int m) {
        int[] div = new int[word.length()];
        long n = 0;
        for (int i = 0; i < word.length(); i++) {
            long digit = word.charAt(i) - '0';
            n = (n * 10 + digit) % m;
            div[i] = (n == 0) ? 1 : 0;
        }
        return div;
    }
}
