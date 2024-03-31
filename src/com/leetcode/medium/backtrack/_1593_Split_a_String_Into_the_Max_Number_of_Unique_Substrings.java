package com.leetcode.medium.backtrack;

import java.util.HashSet;
import java.util.Set;

public class _1593_Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
    //https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
    //1593. Split a String Into the Max Number of Unique Substrings
    //backtrack

    private int max = 0;

    public int maxUniqueSplit(String s) {
        f(s, 0, new HashSet<>());
        return max;
    }

    private void f(String s, int index, Set<String> set) {
        if (index >= s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (set.add(str)) {
                f(s, i, set);
                set.remove(str);
            }
        }
    }
}
