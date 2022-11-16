package com.leetcode.easy.slidingwindow;

public class _2269_Find_the_K_Beauty_of_a_Number {
    static public int divisorSubstrings(int num, int k) {
        int r = 0;
        String n = String.valueOf(num);
        for (int i = 0; i <= n.length() - k; i++) {
            if (num % Integer.parseInt(n.substring(i, i + k)) == 0) {
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int num = 240, k = 2;

        System.out.println(divisorSubstrings(num, k));
    }
}
