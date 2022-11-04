package com.leetcode.easy.simulation;

public class _999_Available_Captures_for_Rook {
    static public int numRookCaptures(char[][] board) {
        int n = -1;
        int m = -1;

        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    m = i;
                    n = j;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (board[m][i] > 65 && board[m][i] < 90) {
                break;
            }
            if (board[m][i] != '.') {
                counter++;
                break;
            }
        }

        for (int i = n + 1; i < 8; i++) {
            if (board[m][i] > 65 && board[m][i] < 90) {
                break;
            }
            if (board[m][i] != '.') {
                counter++;
                break;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            if (board[i][n] > 65 && board[i][n] < 90) {
                break;
            }
            if (board[i][n] != '.') {
                counter++;
                break;
            }
        }

        for (int i = m + 1; i < 8; i++) {
            if (board[i][n] > 65 && board[i][n] < 90) {
                break;
            }
            if (board[i][n] != '.') {
                counter++;
                break;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        char[][] ch =
                {
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','R','.','.','.','p'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','P','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'}
                };

        System.out.println(numRookCaptures(ch));
    }
}
