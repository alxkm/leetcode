package com.company.string;

public class _917_Reverse_Only_Letters {
    static public String reverseOnlyLetters(String s) {
        StringBuilder alp = new StringBuilder();
        StringBuilder plc = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                alp.append(ch);
                plc.append(" ");
            } else {
                plc.append(ch);
            }
        }

        alp.reverse();
        StringBuilder r = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                r.append(alp.charAt(j++));
            } else {
                r.append(plc.charAt(i));
            }
        }
        return r.toString();
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";

        System.out.println(reverseOnlyLetters(s));
    }
}
