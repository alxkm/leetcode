package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _414_Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        if (nums.length == 2) return Math.max(nums[1], nums[0]);
        if (nums.length == 1) return nums[0];

        Set<Integer> set = new HashSet<>();

        for (int j : nums) {
            set.add(j);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);

        list.sort(Comparator.naturalOrder());

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer n = map.get(num);
            if (n != null) map.put(num, ++n);
            else map.put(num, 1);
        }

        if (list.size() >= 3) {
            return list.get(list.size() - 3);
        } else if (list.size() == 2) {
           return list.get(1);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        //int[] nums = {1, 2, 2};
        System.out.println(thirdMax(nums));
    }
}
