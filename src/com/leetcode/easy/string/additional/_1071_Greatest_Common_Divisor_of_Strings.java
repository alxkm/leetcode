package com.leetcode.easy.string.additional;

public class _1071_Greatest_Common_Divisor_of_Strings {
    static public String gcdOfStrings(String str1, String str2) {
        if (str1.startsWith(str2) && str1.endsWith(str2)) {
            if ((str1.length() % str2.length() == 0)) {
                return str2;
            }
        }
        if (str2.startsWith(str1) && str2.endsWith(str1)) {
            if ((str2.length() % str1.length() == 0)) {
                return str1;
            }
        }
        int min = Math.min(str1.length(), str2.length()) / 2;

        String r = "";

        for (int i = 1; i <= min; i++) {
            String s = str1.substring(0, i);
            if (str1.startsWith(s) && str2.startsWith(s) && str1.endsWith(s) && str2.endsWith(s)) {
                if ((str1.length() % s.length() == 0 && str2.length() % s.length() == 0)) {
                    int a = str1.length() / s.length();
                    int b = str2.length() / s.length();

                    if (str1.equals(s.repeat(a)) && str2.equals(s.repeat(b))) {
                        r = s;
                    }
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        String s1 = "ABCABC";
//        String s2 = "ABC";
        //String s1 = "ABABAB";
        //String s2 = "ABAB";

        String s1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String s2 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        System.out.println(gcdOfStrings(s1, s2));
    }
}
