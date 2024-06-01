package com.leetcode.easy.string;

public class _3110_Score_of_a_String {
    //3110. Score of a String
    //https://leetcode.com/problems/score-of-a-string/

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return score;
    }
}
