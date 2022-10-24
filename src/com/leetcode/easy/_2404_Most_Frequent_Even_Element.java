package com.company;

import java.util.HashMap;
import java.util.Map;

public class _2404_Most_Frequent_Even_Element {
    static public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                Integer n = map.get(nums[i]);
                if (n != null) {
                    map.put(nums[i], ++n);
                } else {
                    map.put(nums[i], 1);
                }
            }
        }

        if (map.size() == 0) return -1;

        int max = map.get(map.keySet().toArray()[0]);
        int maxIndex = (Integer)map.keySet().toArray()[0];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                maxIndex = Math.min(maxIndex, entry.getKey());
            } else if (max <= entry.getValue()) {
                max = entry.getValue();
                maxIndex = entry.getKey();
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290};

        System.out.println(mostFrequentEven(nums));
    }
}
