package com.leetcode.easy.array;

public class _3046_Split_the_Array {
    //https://leetcode.com/problems/split-the-array/
    //3046. Split the Array

    public boolean isPossibleToSplit(int[] nums) {
        int[] elementFrequency = new int[101];
        for (int num : nums) {
            elementFrequency[num]++;
            if (elementFrequency[num] > 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleToSplit1(int[] nums) {
        int[] ar = new int[101];
        for (int n: nums) ar[n]++;
        for (int n: ar) if (n > 2) return false;
        int counter = 0;
        for (int n: ar) if (n == 1) counter++;
        return counter % 2 == 0;
    }
}
