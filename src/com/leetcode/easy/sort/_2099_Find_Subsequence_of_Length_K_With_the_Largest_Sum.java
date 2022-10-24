package com.company.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    static public int[] maxSubsequence(int[] nums, int k) {
        int[] b = Arrays.copyOf(nums, nums.length);
        Arrays.sort(b);
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[k];
        for (int i = b.length - 1; i >= 0; i--) {
            if (k > 0) {
                map.put(b[i], map.getOrDefault(b[i], 0) + 1);
                k--;
            } else {
                break;
            }
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            var value = map.get(nums[i]);
            if (value != null && value != 0) {
                a[j++] = nums[i];
                map.put(nums[i], --value);
            }
        }
        return a;
    }

    public static void main(String[] args) {
//        int[] a = {2,1,3,3};
//        int k = 2;
//        int[] a = {-1,-2,3,4};
//        int k = 3;
        int[] a = {50,-75};
        int k = 2;

        System.out.println(Arrays.toString(maxSubsequence(a, k)));
    }
}
