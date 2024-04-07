package com.leetcode.medium.matrix;

public class _289_Game_of_Life {
    //https://leetcode.com/problems/game-of-life/
    //289. Game of Life

    public void gameOfLife(int[][] board) {
        int[][] b = new int[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int counter = 0;
                if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1) {
                    counter++;
                }
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                    counter++;
                }
                if (i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] == 1) {
                    counter++;
                }
                if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                    counter++;
                }
                if (i - 1 >= 0 && board[i - 1][j] == 1) {
                    counter++;
                }
                if (j - 1 >= 0 && board[i][j - 1] == 1) {
                    counter++;
                }
                if (i + 1 < m && board[i + 1][j] == 1) {
                    counter++;
                }
                if (j + 1 < n && board[i][j + 1] == 1) {
                    counter++;
                }

                if (board[i][j] == 1 && counter < 2) {
                    b[i][j] = 0;
                } else if (board[i][j] == 1 && counter == 2 || counter == 3) {
                    b[i][j] = 1;
                } else if (board[i][j] == 1 && counter > 3) {
                    b[i][j] = 0;
                } else if (board[i][j] == 0 && counter == 3) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = board[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = b[i][j];
            }
        }
    }
}
