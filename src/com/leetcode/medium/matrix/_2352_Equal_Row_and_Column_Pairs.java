package com.leetcode.medium.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2352_Equal_Row_and_Column_Pairs {
    //https://leetcode.com/problems/equal-row-and-column-pairs/description/
    //2352. Equal Row and Column Pairs

    public int equalPairs(int[][] grid) {
        Map<String, Integer> indexToRow = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            indexToRow.put(Arrays.toString(grid[i]), indexToRow.getOrDefault(Arrays.toString(grid[i]), 0) + 1);
        }

        int counter = 0;
        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j]);
                if (i + 1 != grid.length) sb.append(", ");
            }
            sb.append("]");
            counter += indexToRow.getOrDefault(sb.toString(), 0);
        }
        return counter;
    }
}
