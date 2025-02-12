package com.leetcode.easy.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _2500_Delete_Greatest_Value_in_Each_Row_ {
    //https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
    //2500. Delete Greatest Value in Each Row

    public int deleteGreatestValue(int[][] grid) {
        List<PriorityQueue<Integer>> l = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
            for (int j = 0; j < grid[0].length; j++) {
                pq.offer(grid[i][j]);
            }
            l.add(pq);
        }
        int s = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, l.get(j).poll());
            }
            s += max;
        }

        return s;
    }
}
