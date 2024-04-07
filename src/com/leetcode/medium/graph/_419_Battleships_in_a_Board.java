package com.leetcode.medium.graph;

public class _419_Battleships_in_a_Board {
    //https://leetcode.com/problems/battleships-in-a-board/
    //419. Battleships in a Board

    int m;
    int n;
    boolean[][] visit;
    char[][] br;

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        br = board;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && br[i][j] == 'X') {
                    dfs(i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || visit[i][j] || br[i][j] == '.') return;

        visit[i][j] = true;

        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
}
