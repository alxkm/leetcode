package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _697_Degree_of_an_Array {
    //697. Degree of an Array
    //https://leetcode.com/problems/degree-of-an-array/

    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> mapOfIndeces = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            var list = mapOfIndeces.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            mapOfIndeces.put(nums[i], list);
        }
        int max = 1;
        int maxValue = nums.length + 1;
        for (var entry: map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                var list = mapOfIndeces.get(entry.getKey());
                Collections.sort(list);
                maxValue = ((list.get(list.size() - 1) - list.get(0)) + 1);
            } else if (entry.getValue() == max) {
                var list = mapOfIndeces.get(entry.getKey());
                Collections.sort(list);
                int newMaxValue = ((list.get(list.size() - 1) - list.get(0)) + 1);
                if (newMaxValue < maxValue) {
                    maxValue = newMaxValue;
                    max = entry.getValue();
                }
            }
        }
        return maxValue;
    }
}
