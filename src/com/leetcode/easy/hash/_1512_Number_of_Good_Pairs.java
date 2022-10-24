package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1512_Number_of_Good_Pairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer ii = map.get(num);
            if (ii != null) {
                map.put(num, ++ii);
            } else {
                map.put(num, 1);
            }
        }
        int counter = 0;
        for (Integer n : map.values()) {
            if (n == 2) {
                counter++;
            } else if (n >= 2) {
                counter += ((n * (n - 1)) / 2);
            }
        }

        return counter;
    }

    public int numIdenticalPairs1(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
