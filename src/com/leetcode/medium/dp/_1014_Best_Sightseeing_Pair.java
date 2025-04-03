package com.leetcode.medium.dp;

public class _1014_Best_Sightseeing_Pair {
    //https://leetcode.com/problems/best-sightseeing-pair/
    //1014. Best Sightseeing Pair
    //FOREIGN

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        // Initialize an array to store the maximum left scores up to each index.
        int[] maxLeftScore = new int[n];
        // The left score at the first index is just the value of the first element.
        maxLeftScore[0] = values[0];

        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            // Update the maximum score by combining the best left score so far with the current right score.
            maxScore = Math.max(
                    maxScore,
                    maxLeftScore[i - 1] + currentRightScore
            );

            int currentLeftScore = values[i] + i;
            // Update the maximum left score up to the current index.
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], currentLeftScore);
        }

        return maxScore;
    }
}
