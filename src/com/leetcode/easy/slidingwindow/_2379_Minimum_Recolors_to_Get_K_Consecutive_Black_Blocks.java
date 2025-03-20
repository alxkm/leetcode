package com.leetcode.easy.slidingwindow;

public class _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {
    //2379. Minimum Recolors to Get K Consecutive Black Blocks
    //https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

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

    public int minimumRecolors1(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        char[] s = blocks.toCharArray();

        int b = 0;
        for (int i = 0; i < s.length && i < k; i++) {
            if (s[i] == 'B') b++;
        }
        min = Math.min(min, k - b);

        for (int i = k; i < s.length; i++) {
            if (s[i] == 'B') b++;
            if (s[i - k] == 'B') b--;
            min = Math.min(min, k - b);
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "WBWBBBW";
        int k = 2;
        System.out.println(minimumRecolors(s, k));
    }
}
