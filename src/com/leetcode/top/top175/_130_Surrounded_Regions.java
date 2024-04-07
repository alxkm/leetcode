package com.leetcode.top.top175;

public class _130_Surrounded_Regions {
    //https://leetcode.com/problems/surrounded-regions/
    //130. Surrounded Regions
    //FOREIGN_SOLUTION

    private char[][] board;
    private int n;
    private int m;
    private boolean[][] visit;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (visit[0][i] != true && board[0][i] == 'O') {
                dfs(0, i);
            }
            if (visit[m - 1][i] != true && board[m - 1][i] == 'O') {
                dfs(m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (visit[i][0] != true && board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (visit[i][n - 1] != true && board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] != true && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i >= m || j >= n || i < 0 || j < 0 || board[i][j] == 'X' || visit[i][j]) return;
        visit[i][j] = true;

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
