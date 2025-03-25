package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2460_Apply_Operations_to_an_Array {
    //2460. Apply Operations to an Array
    //https://leetcode.com/problems/apply-operations-to-an-array/description/

    public int[] applyOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1] && nums[i] != 0) {
                list.add(nums[i] * 2);
                nums[i + 1] = 0;
            } else if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        Arrays.fill(nums, 0);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
