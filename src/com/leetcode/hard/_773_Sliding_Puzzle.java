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

    public int findChampion(int n, int[][] edges) {
        int[] deg = new int[n];
        List[] gr = new List[n];

        for (int[] ar: edges) {
            gr[ar[0]].add(ar[1]);
        }

        for (int[] ar: edges) {
            deg[ar[1]]++;
        }

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                Set<Integer> set = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                for (var a: gr[i]) {
                    q.add((int)a);
                }

                while (!q.isEmpty()) {
                    int v = q.poll();
                    set.add(v);

                    for (var a: gr[v]) {
                        q.add((int)a);
                    }
                }
                if (set.size() == n - 1) return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var sol = new _773_Sliding_Puzzle();
        System.out.println(sol.slidingPuzzle(ArrayUtil.to2d("[[1,2,3],[4,0,5]]")));
    }
}
