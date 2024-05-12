package com.leetcode.cycle_sort;

public class _164_Maximum_Gap {
    //164. Maximum Gap
    //https://leetcode.com/problems/maximum-gap/
    //radix sort
    //bucket sort
    //sort

    public int maximumGap(int[] nums) {
        if (nums.length == 1) return 0;

        nums = radixSort(nums);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }

    public int[] radixSort(int[] nums) {
        int max = nums[0];
        for (int n: nums) {
            max = Math.max(n, max);
        }
        int decPlace = 1;
        while (max > 0) {
            nums = countSort(nums, decPlace);
            max /= 10;
            decPlace *= 10;
        }
        return nums;
    }

    public int[] countSort(int[] nums, int decPlace) {
        int[] count = new int[10];
        for (int n: nums) {
            count[(n / decPlace) % 10]++;
        }
        int startingIndex = 0;
        for (int i = 0; i < count.length; i++) {
            startingIndex += count[i];
            count[i] = startingIndex - count[i];
        }
        int[] sorted = new int[nums.length];
        for (int n: nums) {
            sorted[count[(n / decPlace) % 10]] = n;
            count[(n / decPlace) % 10]++;
        }
        return count;
    }
}
