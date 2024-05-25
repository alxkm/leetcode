package com.leetcode.backtrack_dp;

public class _1255_Maximum_Score_Words_Formed_by_Letters {
    //https://leetcode.com/problems/maximum-score-words-formed-by-letters/
    //1255. Maximum Score Words Formed by Letters

    int[][] w;
    int[] capacity;
    int maxScore = 0;
    int[] cost;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        w = new int[words.length][26];
        cost = score;
        for (int i = 0; i < words.length; i++) {
            int[] w = this.w[i];
            for (char ch : words[i].toCharArray()) {
                w[ch - 'a']++;
            }
        }
        capacity = new int[26];
        for (char letter : letters) {
            capacity[letter - 'a']++;
        }
        f(0, 0);
        return maxScore;
    }

    void f(int i, int score) {
        if (i == w.length) {
            if (maxScore < score) {
                maxScore = score;
            }
            return;
        }

        int[] curWord = w[i];
        boolean enoughCapacity = true;

        for (int j = 0; j < curWord.length; j++) {
            int k = curWord[j];
            if (capacity[j] >= k) continue;
            enoughCapacity = false;
            break;
        }
        if (enoughCapacity) {
            int calcScore = 0;
            int[] copy = capacity.clone();
            for (int j = 0; j < 26; j++) {
                calcScore += curWord[j] * cost[j];
                capacity[j] -= curWord[j];
            }
            f(i + 1, score + calcScore);
            capacity = copy;
        }
        f(i + 1, score);
    }
}
