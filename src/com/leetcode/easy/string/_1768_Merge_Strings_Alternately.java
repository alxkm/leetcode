package com.leetcode.easy.string;

public class _1768_Merge_Strings_Alternately {
    //https://leetcode.com/problems/merge-strings-alternately/
    //1768. Merge Strings Alternately

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }

            if (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    public String mergeAlternately1(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        String w1 = word1;
        String w2 = word2;
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(w1.charAt(i));
            sb.append(w2.charAt(j));
            i++;
            j++;
        }
        while (i < word1.length()) {
            sb.append(w1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            sb.append(w2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
