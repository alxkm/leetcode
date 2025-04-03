package com.leetcode.medium.binsearch;

public class _1760_Minimum_Limit_of_Balls_in_a_Bag {
    //1760. Minimum Limit of Balls in a Bag
    //https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/

    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1, right = 0;
            for (int n : nums) {
                right = Math.max(right, n);
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canDivide(nums, maxOperations, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canDivide(int[] nums, int maxOperations, int penalty) {
            int operations = 0;
            for (int n : nums) {
                // Calculate required operations to make bag <= penalty
                operations += (n - 1) / penalty;
                if (operations > maxOperations) {
                    return false;
                }
            }
            return true;
        }
    }
}
