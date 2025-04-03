package com.leetcode.easy.prefix;

public class _3028_Ant_on_the_Boundary {
    //3028. Ant on the Boundary
    //https://leetcode.com/problems/ant-on-the-boundary/description/

    class Solution {
        public int returnToBoundaryCount(int[] nums) {
            int counter = 0;
            int cur = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int prev = nums[i];
                cur += nums[i];
                if (prev == cur) continue;
                if (cur == 0) counter++;
            }
            return counter;
        }
    }
}
