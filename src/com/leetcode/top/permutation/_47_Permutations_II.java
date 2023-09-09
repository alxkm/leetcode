package com.leetcode.top.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _47_Permutations_II {
    //https://leetcode.com/problems/permutations-ii/
    //FOREIGN_SOLUTION
    //backtrack
    //TOP

    public void f(int i, Map<Integer, Integer> map, int[] nums, int[] l, List<List<Integer>> ll) {
        if (i == nums.length) {
            List<Integer> arrayList = new ArrayList<>();
            for (int n: l) {
                arrayList.add(n);
            }
            ll.add(arrayList);
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                map.put(entry.getKey(), entry.getValue() - 1);
                l[i] = entry.getKey();
                f(i + 1, map, nums, l, ll);
                map.put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        f(0, map, nums, new int[nums.length], ll);
        return ll;
    }
}
