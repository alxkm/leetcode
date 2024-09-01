package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2913_Subarrays_Distinct_Element_Sum_of_Squares_I {
    //2913. Subarrays Distinct Element Sum of Squares I
    //https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i
    //not_optimal

    public int sumCounts(List<Integer> nums) {
        int counter = 0;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                counter += (set.size() * set.size());
            }
        }
        return counter;
    }
}
