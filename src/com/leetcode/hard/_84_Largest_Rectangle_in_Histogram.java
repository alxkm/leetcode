package com.leetcode.hard;

import com.leetcode.ArrayUtil;

import java.util.Stack;

public class _84_Largest_Rectangle_in_Histogram {
    //84. Largest Rectangle in Histogram
    //https://leetcode.com/problems/largest-rectangle-in-histogram/

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && (heights[st.peek()] > heights[i])) {
                int height = heights[st.pop()];
                int widthBoundary = i;
                if (!st.isEmpty()) widthBoundary = st.peek();
                int curArea = height * (i - widthBoundary - 1);
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int curArea = heights[i];
            for (int j = i + 1; j < n && heights[j] != 0; j++) {
                int width = (j - i);
                int height = Math.min(heights[i], heights[j]);
                curArea = width * height;
                maxArea = Math.max(curArea, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        var sol = new _84_Largest_Rectangle_in_Histogram();
        System.out.println(sol.largestRectangleArea2(ArrayUtil.of(2,1,5,6,2,3)));
    }
}
