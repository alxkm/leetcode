package com.company.string;

import java.util.HashSet;
import java.util.Set;

public class _2309_Greatest_English_Letter_in_Upper_and_Lower_Case {
    static public String greatestLetter(String s) {
        Set<Character> upper = new HashSet<>();
        Set<Character> lower = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            if ((int)ch >= 65 && (int)ch <= 90) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }
        char c = '1';
        for (Character ch : upper) {
            if ((int)ch >= c && lower.contains((char)((int)ch - 65 + 97))) {
                c = ch;
            }
        }
        return c == '1' ? "" : "" + c;
    }

    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
    }
}
