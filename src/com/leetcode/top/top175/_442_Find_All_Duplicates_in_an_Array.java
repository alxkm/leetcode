package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {
    //https://leetcode.com/problems/find-all-duplicates-in-an-array/

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            //System.out.println("i = " + i);
            //System.out.println(Arrays.toString(nums));

            int correctIndex = nums[i] - 1;
            if (i != correctIndex && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else i++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                l.add(nums[i]);
            }
        }

        return l;
    }
}
