package com.leetcode.slidingwindow;

public class _3208_Alternating_Groups_II {
    //3208. Alternating Groups II
    //https://leetcode.com/problems/alternating-groups-ii/description/

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        for (int i = 0; i < colors.length; i++) {
            extendedColors[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            extendedColors[colors.length + i] = colors[i];
        }
        int length = extendedColors.length;
        int result = 0;
        int left = 0;
        int right = 1;
        while (right < length) {
            if (extendedColors[right] == extendedColors[right - 1]) {
                left = right;
                right++;
                continue;
            }

            right++;

            if (right - left < k) continue;

            result++;
            left++;
        }

        return result;
    }

    public int numberOfAlternatingGroups1(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Length of current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        // Loop through array with circular traversal
        for (int i = 1; i < length + k - 1; i++) {
            int index = i % length; // Wrap around using modulo

            // Check if current color is the same as last color
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }

            // Extend alternating sequence
            alternatingElementsCount += 1;

            // If sequence length reaches at least k, count it
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }

        return result;
    }
}
