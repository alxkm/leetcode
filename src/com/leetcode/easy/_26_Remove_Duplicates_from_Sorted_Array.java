package com.leetcode.easy;

public class _26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int d = 0, e = nums[0];
        for (int i = 1, j = 1; i < nums.length; i++) {
            if (nums[i] == e) {
                d++;
            } else {
                e = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return nums.length - d;
    }

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println();
    }
}
