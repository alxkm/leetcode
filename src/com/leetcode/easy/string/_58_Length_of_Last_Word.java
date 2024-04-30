package com.leetcode.easy.string;

public class _58_Length_of_Last_Word {
    //58. Length of Last Word
    //https://leetcode.com/problems/length-of-last-word/description/

    public int lengthOfLastWord(String s) {
        if (s.length() == 1) return 1;
        if (!s.contains(" ")) return s.length();
        int i = 0, max = 0, lmax = 0;
        while (i < s.length()) {
            if (Character.isAlphabetic(s.charAt(i))) {
                lmax++;
                max = lmax;
            } else {
                lmax = 0;
            }
            i++;
        }
        return max;
    }

    public int lengthOfLastWord1(String s) {
        s = s.trim();
        String[] ar = s.split(" ");
        s = ar[ar.length - 1];
        s = s.trim();
        return s.length();
    }
}
