package com.leetcode.easy.string;

public class _2716_Minimize_String_Length {
    //2716. Minimize String Length
    //https://leetcode.com/problems/minimize-string-length/description/

    public int minimizedStringLength(String s) {
        boolean[] set = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            set[s.charAt(i) - 'a'] = true;
        }
        int counter = 0;
        for (boolean consist: set) {
            if (consist) {
                counter++;
            }
        }
        return counter;
    }
}
