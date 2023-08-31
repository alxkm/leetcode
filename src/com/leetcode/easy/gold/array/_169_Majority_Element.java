package com.leetcode.easy.gold.array;

import java.util.Arrays;
import java.util.HashMap;

public class _169_Majority_Element {
    //https://leetcode.com/problems/majority-element/

    static public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        int maxSum = 0;

        int prev = nums[0];
        int prevSum = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                prevSum++;
            } else if (nums[i] != prev) {
                if (prevSum > maxSum) {
                    maxSum = prevSum;
                    max = prev;
                }
                prev = nums[i];
                prevSum = 1;
            }
        }
        return max;
    }

    static public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    static public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int fr = map.getOrDefault(n, 0);
            map.put(n, ++fr);
        }
        int f = (nums.length / 2) + 1;
        for (var entry : map.entrySet()) {
            if (entry.getValue() >= f) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        System.out.println(majorityElement(a));
    }
}
