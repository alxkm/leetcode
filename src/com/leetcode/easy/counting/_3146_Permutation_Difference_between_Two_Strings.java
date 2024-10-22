package com.leetcode.easy.counting;

public class _3146_Permutation_Difference_between_Two_Strings {
    //3146. Permutation Difference between Two Strings
    //https://leetcode.com/problems/permutation-difference-between-two-strings/

    public int findPermutationDifference(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.toCharArray()[i];
            map1[ch - 'a'] = i;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.toCharArray()[i];
            map2[ch - 'a'] = i;
        }

        int sum = 0;

        for (int i = 0; i < 26; i++) {
            sum += Math.abs(map1[i] - map2[i]);
        }

        return sum;
    }
}
