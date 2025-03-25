package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3446_Sort_Matrix_by_Diagonals {
    //https://leetcode.com/problems/sort-matrix-by-diagonals/description/
    //3446. Sort Matrix by Diagonals

    public int[][] sortMatrix(int[][] grid) {
        List<int[]> indexesList = new ArrayList<>();
        for (int i = 0; i < grid.length - 1; i++) {
            indexesList.add(new int[]{i, i + 1});
        }
        processPart(grid, indexesList, 1, 1, false);
        for (int i = 0; i < grid.length; i++) {
            indexesList.add(new int[]{i, i});
        }
        processPart(grid, indexesList, 0, -1, true);
        return grid;
    }

    private void processPart(int[][] grid, List<int[]> indexesList, int index, int addition, boolean reverseOrder) {
        while (indexesList.size() > 0) {
            List<Integer> elementsList = new ArrayList<>();
            for (int[] indexes : indexesList) {
                int i = indexes[0];
                int j = indexes[1];
                elementsList.add(grid[i][j]);
            }
            Collections.sort(elementsList);
            int k = (reverseOrder) ? elementsList.size() - 1 : 0;
            for (int[] indexes : indexesList) {
                int i = indexes[0];
                int j = indexes[1];
                grid[i][j] = elementsList.get(k);
                k += addition;
            }
            for (int[] indexes : indexesList) {
                indexes[index]++;
            }
            indexesList.remove(indexesList.size() - 1);
        }
    }
}
