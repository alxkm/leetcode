package com.leetcode.hard;

public class _41_First_Missing_Positive {
    //41. First Missing Positive
    //https://leetcode.com/problems/first-missing-positive/

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if (nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int firstMissingPositive1(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i]> nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        int i = 0;
        while (i < nums.length && !(nums[i] - 1 != i || nums[i] > nums.length || nums[i] < 0)) {
            i++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        var sol = new _41_First_Missing_Positive();
        //System.out.println(sol.firstMissingPositive1(new int[]{3,4,-1,1}));
        //System.out.println(sol.firstMissingPositive1(new int[]{1,2,0}));
        //System.out.println(sol.firstMissingPositive1(new int[]{7,8,9,11,12}));
        //System.out.println(sol.firstMissingPositive1(new int[]{1}));
        System.out.println(sol.firstMissingPositive1(new int[]{2}));
    }
}
