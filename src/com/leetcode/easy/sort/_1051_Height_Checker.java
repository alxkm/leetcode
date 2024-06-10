package com.leetcode.easy.sort;

import java.util.Arrays;

public class _1051_Height_Checker {
    //1051. Height Checker
    //https://leetcode.com/problems/height-checker/description/

    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) cnt++;
        }
        return cnt;
    }

    public int heightChecker1(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int counter = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) counter++;
        }
        return counter;
    }
}
