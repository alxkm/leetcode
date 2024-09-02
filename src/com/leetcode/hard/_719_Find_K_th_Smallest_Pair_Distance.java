package com.leetcode.hard;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class _719_Find_K_th_Smallest_Pair_Distance {
    //719. Find K-th Smallest Pair Distance
    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;

        // Initialize binary search range
        int low = 0;
        int high = nums[arraySize - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;

            // Count pairs with distance <= mid
            int count = countPairsWithMaxDistance(nums, mid);

            // Adjust binary search bounds based on count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int arraySize = nums.length;
        int left = 0;

        for (int right = 0; right < arraySize; ++right) {
            // Adjust the left pointer to maintain the window with distances <=
            // maxDistance
            while (nums[right] - nums[left] > maxDistance) {
                ++left;
            }
            // Add the number of valid pairs ending at the current right index
            count += right - left;
        }
        return count;
    }

    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    map.put(Math.abs(nums[i] - nums[j]), map.getOrDefault(Math.abs(nums[i] - nums[j]), 0) + 1);
                }
            }
            for (var entry: map.entrySet()) {
                if (entry.getValue() >= k) return entry.getKey();
                k -= entry.getValue();
            }
            return 1;
        }
    }
}
