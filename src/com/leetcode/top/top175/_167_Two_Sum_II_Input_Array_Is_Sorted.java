package com.leetcode.top.top175;

import java.util.HashMap;
import java.util.Map;

public class _167_Two_Sum_II_Input_Array_Is_Sorted {
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    //FOREIGN_SOLUTION
    //two pointers, binsearch

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) return new int[] {1, 2};

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            int left = i + 1;
            int right = numbers.length;

            while (left < right) {
                int m = (left + right) / 2;
                if (numbers[m] + n == target) {
                    return new int[] {i + 1, m + 1};
                }
                if (numbers[m] + n > target) {
                    right = m;
                } else {
                    left = m + 1;
                }
            }
        }
        return new int[] {0, 1};
    }

    public int[] twoSum1(int[] numbers, int target) {
        if (numbers.length == 2) return new int[] {1, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (map.containsKey(target - n)) {
                int index = map.get(target - n);
                if (index > i) {
                    return new int[] {i + 1, map.get(target - n) + 1};
                }
                return new int[] {map.get(target - n) + 1, i + 1};
            }
            map.put(n, i);
        }
        return new int[] {0, 1};
    }

    //not working
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return new int[] {0, 1};
    }
}
