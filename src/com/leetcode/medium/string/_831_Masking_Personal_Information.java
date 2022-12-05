package com.leetcode.medium.string;

public class _831_Masking_Personal_Information {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.contains("@")) {
            sb.append(Character.toLowerCase(s.charAt(0))).append("*****");
            for (int i = s.indexOf("@") - 1; i < s.length(); i++) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        } else {
            StringBuilder number = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) number.append(ch);
            }
            String temp = number.toString();
            int size = temp.length();
            String tail = String.valueOf(temp.charAt(size - 4)) + temp.charAt(size - 3) +
                    temp.charAt(size - 2) + temp.charAt(size - 1);
            if (temp.length() <= 10) {
                sb.append("***-***-");
            } else if (temp.length() == 11) {
                sb.append("+*-***-***-");
            } else if (temp.length() == 12) {
                sb.append("+**-***-***-");
            } else if (temp.length() == 13) {
                sb.append("+***-***-***-");
            }
            sb.append(tail);
        }
        return sb.toString();
    }
}
