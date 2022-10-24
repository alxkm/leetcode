package com.company.string;

public class _2108_Find_First_Palindromic_String_in_the_Array {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            if (words[i].equals(sb.toString())) {
                return words[i];
            }
        }
        return "";
    }
}
