package com.leetcode.medium.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _36_Valid_Sudoku {
    //https://leetcode.com/problems/valid-sudoku/
    //36. Valid Sudoku
    //matrix

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                Set<Character> row = rows.getOrDefault(i, new HashSet<>());
                Set<Character> column = columns.getOrDefault(j, new HashSet<>());
                if (row.contains(board[i][j])) return false;
                row.add(board[i][j]);
                rows.put(i, row);
                if (column.contains(board[i][j])) return false;
                column.add(board[i][j]);
                columns.put(j, column);
            }
        }
        return
                isValidQuadrant(0, 0, board)
                        && isValidQuadrant(3, 3, board)
                        && isValidQuadrant(6, 6, board)
                        && isValidQuadrant(3, 0, board)
                        && isValidQuadrant(6, 0, board)
                        && isValidQuadrant(6, 3, board)
                        && isValidQuadrant(0, 3, board)
                        && isValidQuadrant(0, 6, board)
                        && isValidQuadrant(3, 6, board);
    }

    private boolean isValidQuadrant(int x, int y, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
}
