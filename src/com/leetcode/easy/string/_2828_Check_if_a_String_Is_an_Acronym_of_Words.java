package com.leetcode.easy.string;

import java.util.List;

public class _2828_Check_if_a_String_Is_an_Acronym_of_Words {
    //2828. Check if a String Is an Acronym of Words
    //https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (var w: words) {
            sb.append(w.toCharArray()[0]);
        }
        return s.equals(sb.toString());
    }
}
