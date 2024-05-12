package com.leetcode.hard;

import java.util.Stack;

public class _85_Maximal_Rectangle {
    //https://leetcode.com/problems/maximal-rectangle/
    //85. Maximal Rectangle

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix[0].length;
        int[] height = new int[n];

        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                height[j] = (chars[j] == '0') ? 0 : height[j] + 1;
            }
            maxArea = largestRectangleArea(height);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && (heights[st.peek()] > heights[i])) {
                int height = heights[st.pop()];
                int widthBoundary = i;
                if (!st.isEmpty()) widthBoundary = st.peek();
                int curArea = height * (i - widthBoundary - 1);
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(heights[i]);
        }
        return maxArea;
    }
}
