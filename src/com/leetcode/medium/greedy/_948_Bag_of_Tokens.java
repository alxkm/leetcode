package com.leetcode.medium.greedy;

import java.util.Arrays;

public class _948_Bag_of_Tokens {
    //https://leetcode.com/problems/bag-of-tokens/
    //948. Bag of Tokens

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        if (power < tokens[0]) {
            return 0;
        }
        int i = 1;
        int j = tokens.length - 1;
        power -= tokens[0];
        score = 1;
        int max = score;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                score++;
                i++;
                max = Math.max(max, score);
            } else if (score > 0) {
                j--;
                max = Math.max(max, score);
            } else {
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new _948_Bag_of_Tokens();
        System.out.println(sol.bagOfTokensScore(new int[]{200, 100}, 150));
    }
}
