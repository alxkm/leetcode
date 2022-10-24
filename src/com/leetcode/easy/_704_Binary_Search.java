package com.company;

public class _704_Binary_Search {
    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while ((r - l + 1) > 0) {
                int i = (l + r) / 2;
                if (nums[i] > target) {
                    r = i - 1;
                } else if (nums[i] < target) {
                    l = i + 1;
                } else {
                    return i;
                }
            }
            return -1;
        }

        public int search1(int[] a, int x) {
            int l = 0, r = a.length - 1;
            while ((r - l + 1) > 0) {
                int i = (l + r) / 2;
                if (a[i] > x) {
                    r = i - 1;
                } else if (a[i] < x) {
                    l = i + 1;
                } else {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        _704_Binary_Search.Solution s = new _704_Binary_Search.Solution();
        int[] nums = {1};

        System.out.println(s.search(nums, 0));
    }
}
