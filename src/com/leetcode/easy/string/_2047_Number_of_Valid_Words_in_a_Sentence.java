package com.leetcode.easy.string;

import java.util.Set;

public class _2047_Number_of_Valid_Words_in_a_Sentence {
    //2047. Number of Valid Words in a Sentence
    //https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

    //not finished
    public int countValidWords(String sentence) {
        int counter = 0;
        Set<Character> punctuations = Set.of('!', '.', ',');
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            s = s.trim();
            if (s.length() == 1 && punctuations.contains(s.charAt(0))) {
                counter++;
                continue;
            }
            if (s.length() == 0 || !Character.isAlphabetic(s.charAt(0))) continue;
            boolean hasDigit = false;
            int hyphens = 0;
            int punctuation = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                    break;
                } else if (ch == '-') {
                    hyphens++;
                } else if (punctuations.contains(ch)) {
                    punctuation++;
                }
            }
            if (hasDigit) continue;
            if (hyphens > 0) {
                if (hyphens > 1 || (punctuation > 0 && punctuation != 1)) continue;
                if (s.length() >= 3 && s.charAt(0) != '-' && s.charAt(s.length() - 1) != '-') {
                    if (punctuation > 0 && !punctuations.contains(s.charAt(s.length() - 1))) {
                        continue;
                    }
                    counter++;
                }
                continue;
            }
            if (punctuation > 0) {
                if (punctuation != 1) continue;
                if (punctuations.contains(s.charAt(s.length() - 1))) {
                    counter++;
                }
                continue;
            }
            if (s.length() > 0) {
                counter++;
            }
        }
        return counter;
    }
}

//not main implementation
class Solution {
    public int countValidWords(String sentence) {
        int counter = 0;
        Set<Character> punctuations = Set.of('!', '.', ',');
        String[] split = sentence.trim().split("\\s+");

        for (String s : split) {
            s = s.trim();
            if (s.length() == 0) continue;

            boolean hasDigit = false;
            boolean validHyphen = true;
            int hyphens = 0;
            int punctuationCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    hasDigit = true;
                    break;
                }

                if (ch == '-') {
                    hyphens++;
                    if (hyphens > 1 || i == 0 || i == s.length() - 1
                            || !Character.isAlphabetic(s.charAt(i - 1))
                            || !Character.isAlphabetic(s.charAt(i + 1))) {
                        validHyphen = false;
                        break;
                    }
                } else if (punctuations.contains(ch)) {
                    punctuationCount++;
                    if (i != s.length() - 1) {
                        validHyphen = false;
                        break;
                    }
                }
            }

            if (!hasDigit && validHyphen && punctuationCount <= 1) {
                counter++;
            }
        }

        return counter;
    }
}