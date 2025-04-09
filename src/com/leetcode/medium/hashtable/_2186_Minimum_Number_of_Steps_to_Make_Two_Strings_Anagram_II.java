package com.leetcode.medium.hashtable;

public class _2186_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram_II {
    //2186. Minimum Number of Steps to Make Two Strings Anagram II
    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/description/

    public int minSteps(String s, String t) {
        int[] ar = new int[26];
        int[] ar1 = new int[26];

        for (char ch: s.toCharArray()) {
            ar[ch - 'a']++;
        }
        for (char ch: t.toCharArray()) {
            ar1[ch - 'a']++;
        }
        int min = 0;
        for (int i = 0; i < 26; i++) {
            min += Math.abs(ar[i] - ar1[i]);
        }

        return min;
    }
}
