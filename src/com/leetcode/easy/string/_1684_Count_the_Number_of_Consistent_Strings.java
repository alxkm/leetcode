package com.leetcode.easy.string;

import java.util.HashSet;

public class _1684_Count_the_Number_of_Consistent_Strings {
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

    public static void main(String[] args) {
        String s = "ab";
        String[] w = {
                "ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(s, w));
    }
}
