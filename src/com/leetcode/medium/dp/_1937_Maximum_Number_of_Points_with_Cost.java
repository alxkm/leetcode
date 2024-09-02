package com.leetcode.medium.dp;

public class _1937_Maximum_Number_of_Points_with_Cost {
    //1937. Maximum Number of Points with Cost
    //https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
    //FOREIGN_SOLUTION

    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        long[] previousRow = new long[cols];

        // Initialize the first row
        for (int col = 0; col < cols; ++col) {
            previousRow[col] = points[0][col];
        }

        // Process each row
        for (int row = 0; row < rows - 1; ++row) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];
            long[] currentRow = new long[cols];

            // Calculate left-to-right maximum
            leftMax[0] = previousRow[0];
            for (int col = 1; col < cols; ++col) {
                leftMax[col] = Math.max(leftMax[col - 1] - 1, previousRow[col]);
            }

            // Calculate right-to-left maximum
            rightMax[cols - 1] = previousRow[cols - 1];
            for (int col = cols - 2; col >= 0; --col) {
                rightMax[col] = Math.max(
                        rightMax[col + 1] - 1,
                        previousRow[col]
                );
            }

            // Calculate the current row's maximum points
            for (int col = 0; col < cols; ++col) {
                currentRow[col] = points[row + 1][col] +
                        Math.max(leftMax[col], rightMax[col]);
            }

            // Update previousRow for the next iteration
            previousRow = currentRow;
        }

        // Find the maximum value in the last processed row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
