package com.leetcode.easy.array;

public class _3005_Count_Elements_With_Maximum_Frequency {
    //3005. Count Elements With Maximum Frequency
    //https://leetcode.com/problems/count-elements-with-maximum-frequency/

    public int maxFrequencyElements(int[] nums) {
        int[] ar = new int[101];
        int max = 1;
        for (int n: nums) {
            ar[n]++;
            max = Math.max(max, ar[n]);
        }

        int s = 0;
        for (int n: ar) {
            if (n == max) s += n;
        }

        return s;
    }
}
