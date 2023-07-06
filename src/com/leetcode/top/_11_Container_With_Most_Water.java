package com.leetcode.top;

public class _11_Container_With_Most_Water {
    //https://leetcode.com/problems/container-with-most-water/

    public int maxArea(int[] h) {
        int s = 0, i = 0, j = h.length - 1;

        while (i != j) {
            int min = Math.min(h[i], h[j]);
            s = Math.max(s, min * (j - i));
            if (h[i] > h[j]) {
                j--;
            } else {
                i++;
            }
        }

        return s;
    }
}
