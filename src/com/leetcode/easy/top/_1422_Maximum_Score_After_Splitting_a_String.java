package com.leetcode.easy.top;

public class _1422_Maximum_Score_After_Splitting_a_String {
    //https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
    //1422. Maximum Score After Splitting a String
    //prefix
    //string
    //easyTop

    public int maxScore(String s) {
        int n = s.length();
        int[] ones = new int[n];
        ones[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            ones[i] = ones[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int max = 0, zeros = 0;
        for (int i = 0; i < n - 1; i++) {
            zeros += s.charAt(i) == '0' ? 1 : 0;
            max = Math.max(max, zeros + ones[i + 1]);
        }
        return max;
    }

    public int maxScore1(String s) {
        int[] ones = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            ones[i] = ones[i + 1] + (int)(s.charAt(i) - '0');
        }
        int score = 0;
        int z = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') z++;
            score = Math.max(score, z + ones[i + 1]);
        }
        return score;
    }
}
