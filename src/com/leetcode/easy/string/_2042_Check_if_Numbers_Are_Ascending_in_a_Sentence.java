package com.company.string;

public class _2042_Check_if_Numbers_Are_Ascending_in_a_Sentence {
    static public boolean areNumbersAscending(String s) {
        String[] a = s.split(" ");
        Integer prev = null;
        for (String value : a) {
            if (Character.isDigit(value.charAt(0))) {
                int n = Integer.parseInt(value);
                if (prev == null) {
                    prev = n;
                    continue;
                }
                if (prev >= n) {
                    return false;
                }
                prev = n;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("hello world 5 x 5"));
    }
}
