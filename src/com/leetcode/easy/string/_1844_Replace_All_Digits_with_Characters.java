package com.leetcode.easy.string;

public class _1844_Replace_All_Digits_with_Characters {
     static public String replaceDigits(String s) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int prev = 0;
                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] == s.charAt(i - 1)) {
                        prev = j;
                        break;
                    }
                }
                sb.append(alphabet[((int)s.charAt(i) - 48) + prev]);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceDigits("v0g6s4d"));
    }
}
