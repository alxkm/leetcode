package com.leetcode.easy.string;

public class _2609_Find_the_Longest_Balanced_Substring_of_a_Binary_String {
    //https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
    //2609. Find the Longest Balanced Substring of a Binary String

    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ) {
            int z = 0;
            int o = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                z++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1' && z > 0) {
                o++;
                i++;
                z--;
                max = Math.max(max, o * 2);
            }
            while (i < s.length() && s.charAt(i) == '1') i++;
        }
        return max;
    }
}
