package com.company.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1636_Sort_Array_by_Increasing_Frequency {
    static public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer a = map.get(nums[i]);
            if (a != null) {
                map.put(nums[i], ++a);
            } else {
                map.put(nums[i], 1);
            }
        }
        int l = 0;
        int size = map.size();
        for (int i = 0; i < size; i++) {
            int min = 101;
            int minKey = 101;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    minKey = entry.getKey();
                }
                if (entry.getValue() == min) {
                    if (entry.getKey() > minKey) {
                        minKey = entry.getKey();
                    }
                }
            }
            for (int j = 0; j < min; j++) {
                nums[l++] = minKey;
            }
            map.remove(minKey);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,2,3};

        System.out.println(Arrays.toString(frequencySort(a)));
    }
}
