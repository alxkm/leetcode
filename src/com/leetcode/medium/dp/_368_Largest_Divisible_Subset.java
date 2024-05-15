package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _368_Largest_Divisible_Subset {
    //368. Largest Divisible Subset
    //https://leetcode.com/problems/largest-divisible-subset/description/

    private Map<String, List<Integer>> map = new HashMap();
    private int[] nums;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        return f(0, 1);
    }

    public List<Integer> f(int i, int prev) {
        if (i == nums.length) return new ArrayList<>();
        var key = i + "," + prev;
        var val = map.get(key);
        if (val != null) return val;

        val = f(i + 1, prev);
        if (nums[i] % prev == 0) {
            var tmp = f(i + 1, nums[i]);
            if (val.size() < tmp.size() + 1) {
                var list = new ArrayList<Integer>(tmp.size() + 1);
                list.add(nums[i]);
                list.addAll(tmp);
                val = list;
            }
        }

        map.put(key, val);
        return val;
    }
}
