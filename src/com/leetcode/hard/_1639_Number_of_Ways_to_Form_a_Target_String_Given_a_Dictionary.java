package com.leetcode.hard;

import java.util.Arrays;

public class _1639_Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary {
    //https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
    //1639. Number of Ways to Form a Target String Given a Dictionary
    //DP
    //FOREIGN

    public class Solution {

        public int numWays(String[] words, String target) {
            int wordLength = words[0].length();
            int targetLength = target.length();

            // Initialize DP table and frequency table
            int[][] dp = new int[wordLength][targetLength];
            for (int i = 0; i < wordLength; i++) {
                Arrays.fill(dp[i], -1);
            }
            int[][] charFrequency = new int[wordLength][26];

            // Store the frequency of every character at each index in the words
            for (String word : words) {
                for (int j = 0; j < wordLength; j++) {
                    int character = word.charAt(j) - 'a';
                    charFrequency[j][character]++;
                }
            }

            return (int) getWords(words, target, 0, 0, dp, charFrequency);
        }

        private long getWords(
                String[] words,
                String target,
                int wordsIndex,
                int targetIndex,
                int[][] dp,
                int[][] charFrequency
        ) {
            int MOD = 1000000007;

            // If the target is fully matched
            if (targetIndex == target.length()) return 1;

            // If we have no more columns in the words or not enough columns left to match
            // the target
            if (
                    wordsIndex == words[0].length() ||
                            words[0].length() - wordsIndex < target.length() - targetIndex
            ) return 0;

            // If already computed, return the stored result
            if (
                    dp[wordsIndex][targetIndex] != -1
            ) return dp[wordsIndex][targetIndex];

            long countWays = 0;
            int curPos = target.charAt(targetIndex) - 'a';

            // Don't match any character of the target with the current word column
            countWays += getWords(
                    words,
                    target,
                    wordsIndex + 1,
                    targetIndex,
                    dp,
                    charFrequency
            );

            // Match the current character of the target with the current word column
            countWays +=
                    charFrequency[wordsIndex][curPos] *
                            getWords(
                                    words,
                                    target,
                                    wordsIndex + 1,
                                    targetIndex + 1,
                                    dp,
                                    charFrequency
                            );

            // Store the result in dp and return the answer
            dp[wordsIndex][targetIndex] = (int) (countWays % MOD);

            return dp[wordsIndex][targetIndex];
        }
    }
}
