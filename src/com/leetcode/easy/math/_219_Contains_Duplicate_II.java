package com.company.math;

import java.util.HashMap;
import java.util.Map;

public class _219_Contains_Duplicate_II {
    static public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var a = map.get(nums[i]);
            if (a == null) {
                map.put(nums[i], i);
                continue;
            }
            if (Math.abs(i - a) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(a, 1));
    }
}
