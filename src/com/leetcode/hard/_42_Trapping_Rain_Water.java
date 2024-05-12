package com.leetcode.hard;

public class _42_Trapping_Rain_Water {
    //42. Trapping Rain Water
    //https://leetcode.com/problems/trapping-rain-water/description/

    public int trap(int[] height) {
        int sum = 0, l = 0;
        while (l < height.length) {
            int h = height[l];
            boolean found = false;
            while (h > 0) {
                int localSum = 0;
                int r = l + 1;
                while (r < height.length) {
                    if (height[r] >= h) {
                        found = true;
                        break;
                    }
                    localSum += (h - height[r]);
                    r++;
                }
                if (found) {
                    sum += localSum;
                    l = r - 1;
                    break;
                }
                h--;
            }
            l++;
        }
        return sum;
    }

    public int trap1(int[] height) {
        int s = 0, n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        for (int i = 1; i < n - 1; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                s += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return s;
    }
}
