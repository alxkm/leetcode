package com.leetcode.medium.hashtable;

import java.util.Set;

public class _1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
    //https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/?envType=daily-question&envId=2024-09-15
    //1371. Find the Longest Substring Containing Vowels in Even Counts

    public int findTheLongestSubstring(String s) {
        Set<Character> vowels = Set.of( 'a', 'e', 'i', 'o', 'u');
        int l = -1;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                l = i;
                break;
            }
        }
        int r = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (vowels.contains(s.charAt(i))) {
                r = i;
                break;
            }
        }
        if (r == l) return 0;

        int counter = 0;
        for (int i = 0; i < s.length(); i++) if (vowels.contains(s.charAt(i))) counter++;
        if (counter % 2 == 0) return s.length();

        return Math.max(r - 1, s.length() - l - 1);
    }

    public static void main(String[] args) {
        var sol = new _1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts();
        System.out.println(sol.findTheLongestSubstring("eleetminicoworoep"));
    }
}
