package com.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
}
