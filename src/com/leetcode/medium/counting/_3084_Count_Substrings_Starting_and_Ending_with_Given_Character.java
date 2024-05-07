package com.leetcode.medium.counting;

import java.util.ArrayList;
import java.util.List;

public class _3084_Count_Substrings_Starting_and_Ending_with_Given_Character {
    //3084. Count Substrings Starting and Ending with Given Character
    //https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/description/

    public long countSubstrings(String s, char c) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) l. add(i);
        }

        long counter = 0;
        for (int i = 0; i < l.size(); i++) {
            counter += l.size() - i;
        }
        return counter;
    }
}
