package com.leetcode.medium.array;

public class _2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target {
    //https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
    //2023. Number of Pairs of Strings With Concatenation Equal to Target

    public int numOfPairs(String[] nums, String target) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i].length() + nums[j].length() != target.length()) continue;
                if (nums[i].concat(nums[j]).equals(target)) counter++;
            }
        }
        return counter;
    }
}
