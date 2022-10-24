package com.leetcode.easy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2089_Find_Target_Indices_After_Sorting_Array {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                arr.add(i);
            } else if (target < nums[i]) {
                break;
            }
        }
        return arr;
    }
}
