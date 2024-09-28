package com.leetcode.easy.string.additional;

public class _1945_Sum_of_Digits_of_String_After_Convert {
    //1945. Sum of Digits of String After Convert
    //https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/?envType=daily-question&envId=2024-09-03

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

    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char ch: s.toCharArray()) {
                sb.append(ch - 'a' + 1);
            }
            int n = 0;
            while (k > 0) {
                int t = 0;
                for (char ch: sb.toString().toCharArray()) {
                    t += ch - '0';
                }
                sb = new StringBuilder(Integer.valueOf(t).toString());
                n = t;
                k--;
            }
            return n;
        }
    }

    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }
}
