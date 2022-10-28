package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2190_Most_Frequent_Number_Following_Key_In_an_Array {
    public static int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int max = 0;
        int maxVal = 0;
        for (var entry : map.entrySet()) {
            int a = Math.max(max, entry.getValue());
            if (a != max) {
                maxVal = entry.getKey();
                max = entry.getValue();
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
//        int[] a = {2,2,2,2,3};
//        int key = 2;
        int[] a = {2,1000,2,1000,2,3};
        int key = 2;
        System.out.println(mostFrequent(a, key));
    }
}
