package com.leetcode.easy.string.additional;

public class _1544_Make_The_String_Great {
    static public String makeGood(String s) {
        int size = s.length();
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                    if (i >= 1) {
                        if (((int)s.charAt(i) - 65) == ((int)s.charAt(i - 1) - 97)) {
                            String a = s.substring(0, i - 1);
                            String b = (i + 1 != s.length()) ? s.substring(i + 1) : "";
                            s = a + b;
                            break;
                        }
                    }
                    if (i + 1 < s.length()) {
                        if (((int)s.charAt(i) - 65) == ((int)s.charAt(i + 1) - 97)) {
                            String a = s.substring(0, i);
                            String b = s.substring(i + 2);
                            s = a + b;
                            break;
                        }
                    }
                }
            }
            if (size == s.length()) break;
            size = s.length();
        }
        return s;
    }

    public static void main(String[] args) {
        //String s = "abBAcC";
        //String s = "leEeetcode";
        //String s = "AabBaAa";
        String s = "abv";
        System.out.println(makeGood(s));
    }
}
