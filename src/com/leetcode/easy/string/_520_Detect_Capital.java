package com.leetcode.easy.string;

public class _520_Detect_Capital {
    static public boolean detectCapitalUse(String word) {
        int u = 0;
        int l = 0;
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            if (s.equals(word.substring(i, i + 1).toUpperCase())) {
                u++;
                index = i;
            } else {
                l++;
            }
        }
        return u == word.length() || word.length() == l || (word.length() > 1 && u == 1 && index == 0);
    }

    public boolean detectCapitalUse1(String word) {
        if(word.matches("[A-Z]*"))
            return true;
        else if(word.matches("[a-z]*"))
            return true;
        else if(word.matches("[A-Z]{1}|.[a-z]*"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));
    }
}
