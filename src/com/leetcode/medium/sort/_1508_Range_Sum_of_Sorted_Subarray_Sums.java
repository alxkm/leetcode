package com.leetcode.medium.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1508_Range_Sum_of_Sorted_Subarray_Sums {
    //1508. Range Sum of Sorted Subarray Sums
    //https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/?envType=daily-question&envId=2024-08-04

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                l.add(sum);
            }
        }
        Collections.sort(l);
        System.out.println(l);
        //int newn = ((n * (n + 1)) / 2);
        int s = 0;
        for (int i = left - 1; i < right; i++) {
            s = (s + l.get(i)) % 1000000007;
        }

        return s;
    }
}
