package com.leetcode.medium.greedy;

import com.leetcode.ArrayUtil;

public class _2789_Largest_Element_in_an_Array_after_Merge_Operations {
    //2789. Largest Element in an Array after Merge Operations
    //https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/

    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long[] ar = new long[n];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = nums[i];
        }
        if (n == 1) return ar[0];
        if (n == 2) {
            if (ar[0] <= ar[1]) return ar[0] + ar[1];
            else return ar[0];
        }
        long max = 0;
        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i + 1] < ar[i]) continue;
            ar[i] = ar[i] + ar[i + 1];
            max = Math.max(max, ar[i]);
        }
        return Math.max(ar[0], max);
    }

    //todo
    public long maxArrayValue1(int[] nums) {
        long[] ar = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = nums[i];
        }
        while (true) {
            int pairsCounter = 0;
            for (int i = ar.length - 1; i >= 1; i--) {
                if (ar[i] >= ar[i - 1]) {
                    ar[i] += ar[i - 1];
                    ar[i - 1] = 0;
                    pairsCounter++;
                    i--;
                }
            }
            long[] copy = new long[ar.length - pairsCounter];
            for (int i = 0, j = 0; j < ar.length;) {
                if (ar[j] != 0) {
                    copy[i++] = ar[j++];
                } else {
                    j++;
                }
            }
            ar = copy;
            if (pairsCounter == 0) break;
        }
        long max = ar[0];
        for (long n: ar) {
            max = Math.max(n, max);
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new _2789_Largest_Element_in_an_Array_after_Merge_Operations();
        //System.out.println(sol.maxArrayValue(ArrayUtil.of(40,15,35,98,77,79,24,62,53,84,97,16,30,22,49)));
        System.out.println(sol.maxArrayValue(ArrayUtil.of(64,35,42,19,95,8,83,89,33,21,97,11,51,93,36,34,67,53)));

    }
}
