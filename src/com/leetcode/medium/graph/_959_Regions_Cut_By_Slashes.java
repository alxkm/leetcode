package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class _959_Regions_Cut_By_Slashes {
    //959. Regions Cut By Slashes
    //https://leetcode.com/problems/regions-cut-by-slashes/description/

    boolean[][] visit;
    List<ArrayList<Integer>> gr;
    int m;
    int n;

    public int regionsBySlashes(String[] grid) {
        gr = convert(grid);

        for (var s : gr) {
            System.out.println(s);
        }

        visit = new boolean[gr.size()][gr.get(0).size()];
        m = gr.size();
        n = gr.get(0).size();
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gr.get(i).get(j) == 0 && !visit[i][j]) {
                    dfs(i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (gr.get(i).get(j) != 0) return;
        if (visit[i][j]) return;
        visit[i][j] = true;

        dfs(i, j + 1);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i - 1, j);
    }

    private static List<ArrayList<Integer>> convert(String[] grid) {
        List<ArrayList<Integer>> l = new ArrayList<>();

        for (String s : grid) {
            char[] ch = s.toCharArray();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            for (char c : ch) {
                if (c == ' ') {
                    a.add(0);
                    a.add(0);
                    a.add(0);
                    a1.add(0);
                    a1.add(0);
                    a1.add(0);
                    a2.add(0);
                    a2.add(0);
                    a2.add(0);
                }
                else if (c == '/') {
                    a.add(0);
                    a.add(0);
                    a.add(1);
                    a1.add(0);
                    a1.add(1);
                    a1.add(0);
                    a2.add(1);
                    a2.add(0);
                    a2.add(0);
                } else if (c == '\\') {
                    a.add(1);
                    a.add(0);
                    a.add(0);
                    a1.add(0);
                    a1.add(1);
                    a1.add(0);
                    a2.add(0);
                    a2.add(0);
                    a2.add(1);
                }
            }
            l.add(a);
            l.add(a1);
            l.add(a2);
        }

        return l;
    }
}
