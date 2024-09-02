package com.leetcode.easy.string.additional;

import java.util.ArrayList;
import java.util.List;

public class _2942_Find_Words_Containing_Character {
    //2942. Find Words Containing Character
    //https://leetcode.com/problems/find-words-containing-character/description/

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                l.add(i);
            }
        }
        return l;
    }
}
