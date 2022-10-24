package com.leetcode.easy.string.additional;

import java.util.HashSet;
import java.util.Set;

public class _1763_Longest_Nice_Substring {
     static public String longestNiceSubstring(String s) {
        String maxStr = "";
        for (int i = 2; i <= s.length(); i++) {

            for (int j = 0; j <= s.length() - i; j++) {
                Set<Character> set = new HashSet<>();
                Set<Character> set1 = new HashSet<>();
                String str = s.substring(j, j + i);

                for (char ch : str.toCharArray()) {
                    if ((int)ch >= 97) set.add(ch);
                    else set1.add(ch);
                }
                int size = 0;
                for (char a : set) {
                    if (set1.contains((char)(((int)a - 97) + 65))) {
                        size++;
                    }
                }
                if (size == set1.size()
                        && size == set.size()
                        && maxStr.length() < str.length()) maxStr = str;
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring( "Bb"));
    }
}
