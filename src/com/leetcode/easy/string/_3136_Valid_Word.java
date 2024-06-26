package com.leetcode.easy.string;

import java.util.Set;

public class _3136_Valid_Word {
    //3136. Valid Word
    //https://leetcode.com/problems/valid-word

    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        Set<Character> vovels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] ch = word.toCharArray();
        boolean vovel = false;
        boolean consonant = false;
        int i = 0;
        while (i < ch.length) {
            char c = ch[i];
            if (Character.isAlphabetic(ch[i]) || Character.isDigit(ch[i])) {
                if (Character.isAlphabetic(c)) {
                    if (vovels.contains(c)) vovel = true;
                    else consonant = true;
                }
                i++;
            } else {
                return false;
            }
        }
        return vovel && consonant;
    }
}
