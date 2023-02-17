package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _228_Summary_Ranges {
    //https://leetcode.com/problems/summary-ranges/
    //228. Summary Ranges

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int min = nums[0];
        List<String> l = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (min == nums[i - 1]) {
                    l.add(Integer.valueOf(min).toString());
                } else {
                    l.add(min + "->" + nums[i - 1]);
                }
                min = nums[i];
            }
        }
        if (min == nums[nums.length - 1]) {
            l.add(Integer.valueOf(min).toString());
        } else {
            l.add(min + "->" + nums[nums.length - 1]);
        }
        return l;
    }
}
