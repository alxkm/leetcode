package com.leetcode.medium.matrix;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _2661_First_Completely_Painted_Row_or_Column {
    //2661. First Completely Painted Row or Column
    //https://leetcode.com/problems/first-completely-painted-row-or-column/?envType=daily-question&envId=2025-01-20

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Pair<Integer, Integer>> mappedNumbers = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mappedNumbers.put(mat[i][j], new Pair<>(i, j));
            }
        }
        int[] rows = new int[m];
        int[] cols = new int[n];

        int row = 0;
        int col = 0;
        for (int l = 0; l < arr.length; l++) {
            Pair<Integer, Integer> ij = mappedNumbers.get(arr[l]);
            int i = ij.getKey();
            int j = ij.getValue();

            rows[i]++;
            cols[j]++;

            row = Math.max(rows[i], row);
            col = Math.max(cols[j], col);

            if (row == n || col == m) return l;
        }
        return arr.length;
    }
}
