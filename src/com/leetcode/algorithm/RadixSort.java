package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort {
    public int maximumGap(int[] nums) {
        if (nums.length == 1) return 0;
        // Arrays.sort(nums);
        int max = nums[0];
        for (int n: nums) max = Math.max(n, max);
        int dec = 1;
        while (max > 0) {
            nums = count(nums, dec);
            max /= 10;
            dec *= 10;
        }
        System.out.println(Arrays.toString(nums));
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }

    public int[] count(int[] nums, int dec) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n: nums) {
            map.computeIfAbsent((n / dec) % 10, k -> new ArrayList<>()).add(n);
        }
        int[] count = new int[nums.length];
        for (int i = 0, j = 0; i < 10; i++) {
            for (int n: map.get(i)) {
                count[j++] = n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new RadixSort();
        System.out.println(sol.maximumGap(new int[]{1129, 1123, 1125, 2}));
    }
}
