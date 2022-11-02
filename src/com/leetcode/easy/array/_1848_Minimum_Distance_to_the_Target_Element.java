package com.leetcode.easy.array;

public class _1848_Minimum_Distance_to_the_Target_Element {
    static public int getMinDistance(int[] nums, int target, int start) {
        int v1 = 1000000;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                v1 = Math.abs(start - i);
                break;
            }
        }
        int v2 = 10000000;
        for (int i = start; i >= 0; i--) {
            if (nums[i] == target) {
                v2 = Math.abs(start - i);
                break;
            }
        }
        return Math.min(v1, v2);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 4, 5};
        int target = 5;
        int start = 2;
        System.out.println(getMinDistance(a, target, start));
    }
}
