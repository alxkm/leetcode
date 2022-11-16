package com.leetcode.easy.slidingwindow;

public class _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {
    public static int minimumRecolors(String blocks, int k) {
        int min = 10000;
        for (int i = 0; i <= blocks.length() - k; i++) {
            int c = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'B') {
                    c++;
                }

            }
            min = Math.min(min, k - c);
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "WBWBBBW";
        int k = 2;
        System.out.println(minimumRecolors(s, k));
    }
}
