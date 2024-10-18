package com.leetcode.medium.backtrack;

import com.leetcode.ArrayUtil;

public class _2044_Count_Number_of_Maximum_Bitwise_OR_Subsets {
    //2044. Count Number of Maximum Bitwise-OR Subsets
    //https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2024-10-18
    //backtracking

    public int countMaxOrSubsets(int[] nums) {
        int[] max = new int[1];
        int[] maxCount = new int[1];
        f(nums, 0, 0, max, maxCount);
        return maxCount[0];
    }

    public void f(int[] nums, int i, int prev, int[] max, int[] maxCount) {
        if (i == nums.length) {
            if (max[0] == prev) {
                maxCount[0]++;
            } else if (max[0] < prev) {
                max[0] = prev;
                maxCount[0] = 1;
            }
            return;
        }

        f(nums, i + 1, prev | nums[i], max, maxCount);
        f(nums, i + 1, prev, max, maxCount);
    }

    /*
    with a bitwise OR of 7:
    - [3,5]
    - [3,1,5]
    - [3,2,5]
    - [3,2,1,5]
    - [2,5]
    - [2,1,5]
    *
    * */
    public static void main(String[] args) {
        var sol = new _2044_Count_Number_of_Maximum_Bitwise_OR_Subsets();
        System.out.println(sol.countMaxOrSubsets(ArrayUtil.of(3,2,1,5)));
    }
}
