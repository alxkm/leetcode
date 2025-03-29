package com.leetcode.medium.intervals;

import java.util.Arrays;

public class _3394_Check_if_Grid_can_be_Cut_into_Sections {
    //3394. Check if Grid can be Cut into Sections
    //https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/?envType=daily-question&envId=2025-03-25

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    private boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));
        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            if (furthestEnd <= rect[dim]) {
                gapCount++;
            }
            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        return gapCount >= 2;
    }
}
