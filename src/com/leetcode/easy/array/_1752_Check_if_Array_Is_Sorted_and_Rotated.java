package com.leetcode.easy.array;

public class _1752_Check_if_Array_Is_Sorted_and_Rotated {
    //1752. Check if Array Is Sorted and Rotated
    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

    static public boolean check(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int prevIndex = (1 + i) % nums.length;
            int n = (2 + i) % nums.length;
            if (nums[2] == nums[n])
                return true;
        }
        return false;
    }

    public boolean check1(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i+1]){
                continue;
            } index = i;
            break;
        }
        if (index != -1){
            for (int i = index; i < nums.length - 1; i++) {
                if(nums[i] >= nums[i+1]) {
                    continue;
                } return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
            int[] a = {3,4,5,1,2};

        System.out.println(check(a));

    }
}
