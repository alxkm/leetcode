package com.leetcode.easy.string;

import java.util.Set;

public class _824_Goat_Latin {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder();
        String a = "a";

        for (int i = 0; i < s.length; i++) {
            String w = s[i];
            if (v.contains(w.charAt(0))) {
                sb.append(w).append("ma");
            } else {
                sb.append(w.substring(1)).append(w.charAt(0)).append("ma");
            }
            sb.append(a);

            if (i != s.length - 1) {
                sb.append(" ");
            }
            a = a + "a";
        }

        return sb.toString();
    }
}
