package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class _2785_Sort_Vowels_in_a_String {
    //https://leetcode.com/problems/sort-vowels-in-a-string/
    //2785. Sort Vowels in a String

    public String sortVowels(String s) {
        Set<Character> set = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> volwes = new ArrayList<>();

        for (char ch: s.toCharArray()) {
            if (set.contains(ch))
                volwes.add(ch);
        }

        Collections.sort(volwes);

        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                sb.append(volwes.get(j++));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
