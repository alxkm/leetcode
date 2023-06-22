package com.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class _2586_Count_the_Number_of_Vowel_Strings_in_Range {
    //https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/

    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        int counter = 0;
        for (int i = left; i <= right; i++) {
            if (
                    set.contains(words[i].charAt(0))
                            && set.contains(words[i].charAt(words[i].length() - 1))
            ) counter++;
        }
        return counter;
    }
}
