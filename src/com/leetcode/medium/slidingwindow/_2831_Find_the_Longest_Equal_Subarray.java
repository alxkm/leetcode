package com.leetcode.medium.slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2831_Find_the_Longest_Equal_Subarray {
    //https://leetcode.com/problems/find-the-longest-equal-subarray
    //2831. Find the Longest Equal Subarray
    //FOREIGN_SOLUTION

    //not finished
    public int longestEqualSubarray1(List<Integer> nums, int k) {
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), s -> new ArrayList<>()).add(i);
        }
        for (var l: map.values()) {
            Collections.sort(l);
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> curNumberArray = map.get(nums.get(i));
            int localMax = 0;
            int diff = 0;
            int prevPos = i;

            for (int j = curNumberArray.indexOf(i); j < curNumberArray.size() && diff <= k ; j++) {
                int curPos = curNumberArray.get(j);
                if (diff == k && prevPos + 1 != curPos && curPos != prevPos) break;
                if (prevPos != curPos
                        && prevPos + 1 != curPos
                        && prevPos + 1 != curPos) diff += curPos - (prevPos + 1);
                prevPos = curPos;
                localMax++;
                if (diff <= k) max = Math.max(max, localMax);
            }
        }
        return max;
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int maxFrequency = 0, s = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            map.put(val, map.getOrDefault(val, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(val));
            int extraElementCount = (i - s + 1) - maxFrequency;

            if (extraElementCount > k) {
                int num = nums.get(s);
                map.put(num, map.get(num) - 1);
                s++;
            }
        }
        return maxFrequency;
    }

    public static void main(String[] args) {
        var sol = new _2831_Find_the_Longest_Equal_Subarray();
        //System.out.println(sol.longestEqualSubarray(List.of(1, 1), 0));
        //System.out.println(sol.longestEqualSubarray(List.of(1, 2, 1), 0));
        System.out.println(sol.longestEqualSubarray(List.of(4,4,2,2,4), 1));
        System.out.println(sol.longestEqualSubarray(List.of(1,3,2,3,1,3), 3));
        System.out.println(sol.longestEqualSubarray(List.of(1, 3, 2, 3, 1, 3, 3, 4, 5, 3, 3, 3, 3), 3));
    }
}
