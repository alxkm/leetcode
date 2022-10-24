package com.company;

public class _35_Search_Insert_Position {
    static class Solution {
        public int searchInsert(int[] a, int x) {
            int l = -1, r = a.length - 1;

            if (a[a.length - 1] < x) return a.length;

            while ((r - l) > 1) {
                int m = (r + l) / 2;
                if (a[m] < x) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,5,6};

        System.out.println(s.searchInsert(nums, 7));
    }
}
