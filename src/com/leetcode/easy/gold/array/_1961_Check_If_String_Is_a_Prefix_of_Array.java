package com.leetcode.easy.gold.array;

public class _1961_Check_If_String_Is_a_Prefix_of_Array {
    public boolean isPrefixString(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                s = s.substring(words[i].length());
                if (s.equals("")) return true;;
            } else {
                return false;
            }
        }
        if (!s.equals("")) return false;
        return true;
    }
}
