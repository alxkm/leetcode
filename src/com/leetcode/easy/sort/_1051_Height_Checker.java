package com.company.sort;

import java.util.Arrays;

public class _1051_Height_Checker {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) cnt++;
        }
        return cnt;
    }
}
