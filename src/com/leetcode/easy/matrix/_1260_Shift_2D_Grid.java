package com.leetcode.easy.matrix;

import java.util.ArrayList;
import java.util.List;

public class _1260_Shift_2D_Grid {
    //https://leetcode.com/problems/shift-2d-grid/

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k %= grid.length * grid[0].length;
        List<List<Integer>> list = new ArrayList<>();
        int[] a = new int[grid[0].length * grid.length];
        for (int i = 0, l = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                a[l++] = grid[i][j];
            }
        }
        r(a, 0, a.length - 1);
        r(a, 0, k - 1);
        r(a, k, a.length - 1);
        for (int i = 0, l = 0; i < grid.length; i++) {
            var ll = new ArrayList<Integer>();
            for (int j = 0; j < grid[0].length; j++) {
                ll.add(a[l++]);
            }
            list.add(ll);
        }
        return list;
    }

    private void r(int[] a, int l, int r) {
        while (l <= r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
