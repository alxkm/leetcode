package com.leetcode.easy.string;

import java.util.Set;

public class  _1704_Determine_if_String_Halves_Are_Alike {
    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length() / 2);
        s = s.substring(s.length() / 2);
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (v.contains(s.charAt(i))) a++;
            if (v.contains(s1.charAt(i))) b++;
        }
        return a == b;
    }
}
