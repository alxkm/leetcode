package com.leetcode.easy.string.additional;

public class _1945_Sum_of_Digits_of_String_After_Convert {
    static public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            sb.append((int)ch - 96);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (int j = 0; j < sb.length(); j++)
                sum += sb.charAt(j) - 48;
            sb = new StringBuilder(Integer.valueOf(sum).toString());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }
}
