package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1408_String_Matching_in_an_Array {
    //1408. String Matching in an Array
    //https://leetcode.com/problems/string-matching-in-an-array/description/

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[j].contains(s)) {
                    set.add(s);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
