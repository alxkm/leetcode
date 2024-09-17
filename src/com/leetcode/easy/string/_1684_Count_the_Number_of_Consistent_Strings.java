package com.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class _1684_Count_the_Number_of_Consistent_Strings {
    //1684. Count the Number of Consistent Strings
    //https://leetcode.com/problems/count-the-number-of-consistent-strings/description/

    static public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;

        var set = new HashSet<Character>();

        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        for (String word : words) {
            boolean consist = true;
            for (int j = 0; j < word.length(); j++) {
                if (!set.contains(word.charAt(j))) {
                    consist = false;
                    break;
                }
            }
            if (consist) counter++;
        }
        return counter;
    }

    public int countConsistentStrings1(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char ch: allowed.toCharArray()) set.add(ch);
        int counter = 0;
        for (String s: words) {
            boolean isConsistent = true;
            for (char ch: s.toCharArray()) {
                if (!set.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        String s = "ab";
        String[] w = {
                "ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(s, w));
    }
}
