package com.leetcode.easy.array;

import java.util.List;

public class _2824_Count_Pairs_Whose_Sum_is_Less_than_Target {
    //https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
    //2824. Count Pairs Whose Sum is Less than Target

    public int countPairs(List<Integer> nums, int target) {
        int[] ns = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            ns[i] = nums.get(i);
        }
        int counter = 0;
        for (int i = 0; i < ns.length; i++) {
            for (int j = i + 1; j < ns.length; j++) {
                if (ns[i] + ns[j] < target) counter++;
            }
        }
        return counter;
    }
}
