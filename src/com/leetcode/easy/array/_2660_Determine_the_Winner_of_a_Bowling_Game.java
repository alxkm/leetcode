package com.leetcode.easy.array;

public class _2660_Determine_the_Winner_of_a_Bowling_Game {
    //2660. Determine the Winner of a Bowling Game
    //https://leetcode.com/problems/determine-the-winner-of-a-bowling-game

    public int isWinner(int[] player1, int[] player2) {
        int score1 = countScore(player1);
        int score2 = countScore(player2);

        if (score1 == score2) return 0;
        return (score1 > score2) ? 1 : 2;
    }

    private int countScore(int[] player) {
        int score = player[0];
        if (player.length >= 2) {
            score += (player[0] == 10) ? player[1] * 2 : player[1];
        }
        for (int i = 2; i < player.length; i++) {
            if (player[i - 1] == 10 || player[i - 2] == 10) {
                score += player[i] * 2;
            } else {
                score += player[i];
            }
        }
        return score;
    }
}
