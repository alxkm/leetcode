package com.leetcode.medium.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {
    //2033. Minimum Operations to Make a Uni-Value Grid
    //https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2025-03-26

    public int minOperations(int[][] grid, int x) {
        Set<Integer> set = new HashSet<>();
        for (int[] ar : grid) {
            for (int a : ar) {
                set.add(a % x);
                if (set.size() >= 2) return -1;
            }
        }
        int[] arr = new int[grid.length * grid[0].length];

        for (int i = 0, k = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int m = arr[arr.length / 2];
        int c = 0;

        for (int n : arr) {
            c += Math.abs(m - n) / x;
        }

        return c;
    }
}
