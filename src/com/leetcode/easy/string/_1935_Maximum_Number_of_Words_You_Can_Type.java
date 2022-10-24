package com.company.string;

import java.util.HashSet;
import java.util.Set;

public class _1935_Maximum_Number_of_Words_You_Can_Type {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int counter = 0;
        for (int i = 0; i < s.length; i++) {
            boolean is = true;

            for (int j = 0; j < s[i].length(); j++) {
                if (set.contains(s[i].charAt(j))) {
                    is = false;
                    break;
                }
            }

            if (is) counter++;
        }
        return counter;
    }
}
