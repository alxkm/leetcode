package com.leetcode.easy.string;

public class _1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {
    static public String freqAlphabets(String s) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i + 2 <= (s.length() - 1) && s.charAt(i + 2) == '#') {
                int a = Integer.parseInt(String.valueOf(s.charAt(i)) + s.charAt(i + 1));
                sb.append(alphabet[a - 1]);
                i += 2;
            } else {
                sb.append(alphabet[(int)s.charAt(i) - 48 - 1]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
}
