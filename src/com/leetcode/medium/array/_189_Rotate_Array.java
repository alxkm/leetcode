package com.leetcode.medium.array;

public class _189_Rotate_Array {
    //https://leetcode.com/problems/rotate-array/
    //todo todo todo

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        r(nums, 0, n - 1);
        r(nums, 0, k - 1);
        r(nums, k, n - 1);
    }

    private void r(int[] n, int l, int r) {
        while (l <= r) {
            int temp = n[l];
            n[l] = n[r];
            n[r] = temp;
            l++;
            r--;
        }
    }
}
