package com.leetcode.easy.array;

import com.leetcode.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1636_Sort_Array_by_Increasing_Frequency {
    //1636. Sort Array by Increasing Frequency
    //https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

    public int[] frequencySort(int[] nums) {
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

    public int[] frequencySort1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        int[][] ar = new int[map.size()][2];
        int i = 0;
        for (var entry : map.entrySet()) {
            ar[i][0] = entry.getValue();
            ar[i][1] = entry.getKey();
            i++;
        }

        Arrays.sort(ar, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });

        int[] array = new int[nums.length];
        i = 0;
        int k = 0;
        while (i < nums.length) {
            array[i] = ar[k][1];
            for (int j = 0; j < ar[k][0]; j++) {
                array[i] = ar[k][1];
                i++;
            }
            k++;
        }
        return array;
    }

    public static void main(String[] args) {
        var sol = new _1636_Sort_Array_by_Increasing_Frequency();
        System.out.println(sol.frequencySort1(ArrayUtil.of(1, 1, 2, 2, 2, 3)));
        System.out.println(Arrays.toString(sol.frequencySort(ArrayUtil.of(1, 1, 2, 2, 2, 3))));
    }
}
