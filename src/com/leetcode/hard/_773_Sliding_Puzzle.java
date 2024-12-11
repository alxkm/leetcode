package com.leetcode.hard;

import com.leetcode.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _773_Sliding_Puzzle {
    //https://leetcode.com/problems/sliding-puzzle/description/
    //773. Sliding Puzzle

    int[][] win = new int[][] {{1,2,3},{4,5,0}};

    public int slidingPuzzle(int[][] board) {
        Set<String> set = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        q.add(board);
        int[][] dxdy = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int depth = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            depth++;
            while (s > 0) {
                int[][] b = q.poll();
                set.add(Arrays.deepToString(b));
                int x = 0;
                int y = 0;
                for (int i = 0; i < b.length; i++) {
                    for (int j = 0; j < b[0].length; j++) {
                        if (b[i][j] == 0) {
                            x = i;
                            y = j;
                            break;
                        }
                    }
                }

                for (int[] dx : dxdy) {
                    int a1 = x + dx[0];
                    int b1 = y + dx[1];

                    if (!(a1 >= 0 && a1 < b.length && b1 >= 0 && b1 < b[0].length)) continue;
                    int[][] newb = b.clone();
                    int element = newb[a1][b1];
                    newb[x][y] = element;
                    newb[a1][b1] = 0;
                    if (!set.contains(Arrays.deepToString(newb))) {
                        if (Arrays.deepEquals(win, newb)) return depth;
                        q.add(newb);
                    }
                }
                s--;
            }
        }
        return -1;
    }

    class Solution {
        int[][] win = new int[][] {{1, 2, 3}, {4, 5, 0}};

        public int slidingPuzzle(int[][] board) {
            Set<String> visited = new HashSet<>();
            Queue<int[][]> q = new LinkedList<>();
            q.add(deepCopy(board));
            visited.add(boardToString(board));
            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int depth = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[][] current = q.poll();
                    if (Arrays.deepEquals(current, win)) return depth;

                    int zeroX = 0, zeroY = 0;
                    for (int x = 0; x < current.length; x++) {
                        for (int y = 0; y < current[0].length; y++) {
                            if (current[x][y] == 0) {
                                zeroX = x;
                                zeroY = y;
                            }
                        }
                    }

                    for (int[] d : directions) {
                        int newX = zeroX + d[0], newY = zeroY + d[1];
                        if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                            int[][] newBoard = deepCopy(current);

                            newBoard[zeroX][zeroY] = newBoard[newX][newY];
                            newBoard[newX][newY] = 0;

                            String newState = boardToString(newBoard);
                            if (!visited.contains(newState)) {
                                visited.add(newState);
                                q.add(newBoard);
                            }
                        }
                    }
                }
                depth++;
            }
            return -1;
        }

        private int[][] deepCopy(int[][] board) {
            int[][] copy = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                copy[i] = board[i].clone();
            }
            return copy;
        }

        private String boardToString(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int[] row : board) {
                for (int num : row) {
                    sb.append(num);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        var sol = new _773_Sliding_Puzzle();
        System.out.println(sol.slidingPuzzle(ArrayUtil.to2d("[[1,2,3],[4,0,5]]")));
    }
}
