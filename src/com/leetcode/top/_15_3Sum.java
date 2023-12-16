package com.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _15_3Sum {
    //https://leetcode.com/problems/3sum/

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<String> exist = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                int j = i + 1;
                int k = nums.length - 1;
                while (j != k) {
                    int cur = nums[i] + nums[j] + nums[k];
                    if (cur == 0) {
                        String str = "i "+ nums[i] + "j " + nums[j] + "k " + nums[k];
                        if (!exist.contains(str)) {
                            list.add(List.of(nums[i], nums[j], nums[k]));
                            exist.add(str);
                        }
                        j++;
                    } else {
                        if (cur > 0) {
                            k--;
                        } else {
                            j++;
                        }
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> duplicatedSet = new HashSet<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!duplicatedSet.add(nums[i])) continue;

            for (int j = i + 1; j < nums.length; j++) {
                int value = 0 - nums[i] - nums[j];
                if (map.containsKey(value) && map.get(value) == i) {
                    var list = new ArrayList<>(List.of(nums[i], nums[j], value));
                    Collections.sort(list);
                    set.add(list);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<String> existed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                var cur = nums[i] + nums[l] + nums[r];
                if (cur == 0) {
                    if (existed.add((nums[i] + " " + nums[l] + " " + nums[r]))) {
                        ll.add(List.of(nums[i], nums[l], nums[r]));
                    }
                    l++;
                    r--;
                } else {
                    if (cur < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ll;
    }
}
