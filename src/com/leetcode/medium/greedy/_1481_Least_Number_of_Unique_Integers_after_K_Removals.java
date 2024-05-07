package com.leetcode.medium.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1481_Least_Number_of_Unique_Integers_after_K_Removals {
    //1481. Least Number of Unique Integers after K Removals
    //https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] nums = new int[map.size()];
        int i = 0;
        for (int e: map.values()) {
            nums[i++] = e;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (i = 0; i < nums.length; i++) {
            if (k > 0 && k >= nums[i]) {
                k -= nums[i];
                nums[i] = 0;
            }
            if (nums[i] > 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        var sol = new _1481_Least_Number_of_Unique_Integers_after_K_Removals();
        System.out.println(sol.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
