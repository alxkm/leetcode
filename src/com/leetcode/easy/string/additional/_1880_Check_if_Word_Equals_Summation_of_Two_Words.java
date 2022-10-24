package com.leetcode.easy.string.additional;

public class _1880_Check_if_Word_Equals_Summation_of_Two_Words {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (char ch : firstWord.toCharArray()) {
            sb1.append(ch - 97);
        }
        for (char ch : secondWord.toCharArray()) {
            sb2.append(ch - 97);
        }

        for (char ch : targetWord.toCharArray()) {
            sb3.append(ch - 97);
        }

        return (Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString()))
                == Integer.parseInt(sb3.toString());
    }
}
