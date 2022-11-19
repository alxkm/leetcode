package com.leetcode.easy.math;

public class _2119_A_Number_After_a_Double_Reversal {
    static public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();
        int zeros = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeros++;
            } else {
                break;
            }
        }
        sb = new StringBuilder(sb.substring(zeros));
        sb.reverse();
        return Integer.parseInt(sb.toString()) == num;
    }

    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(256));
    }
}
