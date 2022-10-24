package com.company;

import java.util.List;

public class _345_Reverse_Vowels_of_a_String {
    static public String reverseVowels(String s) {
        char[] s1 = s.toCharArray();
        if (s1.length == 1) return s;
        List<Character> l = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0, j = s1.length - i - 1;i < s.length();) {
            if (j < i) break;
            if (l.contains(s1[i]) && l.contains(s1[j])) {
                char ch = s1[i];
                s1[i] = s1[j];
                s1[j] = ch;
                i++;
                j--;
            } else if (!l.contains(s1[i]) && !l.contains(s1[j])) {
                i++;
                j--;
            } else if (!l.contains(s1[i])) {
                i++;
            } else if (!l.contains(s1[j])) {
                j--;
            }
        }
        return String.valueOf(s1);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Marge, let's \"went.\" I await news telegram."));
    }
}
