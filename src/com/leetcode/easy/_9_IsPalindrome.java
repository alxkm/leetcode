package com.company;

public class _9_IsPalindrome {

    public static boolean isPalindrome(String s) {
        s.trim();
        if (s.equals("")) return true;
        if (s.length() == 1) return true;

        StringBuilder cs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                cs.append(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isDigit(s.charAt(i))) {
                cs.append(s.charAt(i));
            }
        }
        String inOrder = cs.toString();
        String reverseOrder = cs.reverse().toString();
        return inOrder.equals(reverseOrder);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
