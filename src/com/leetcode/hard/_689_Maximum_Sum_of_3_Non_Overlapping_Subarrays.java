package com.leetcode.hard;

import com.leetcode.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays {
    //689. Maximum Sum of 3 Non-Overlapping Subarrays
    //https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
    //DP
    //FOREIGN

    class Solution {
        List<Integer> ksum = new ArrayList<>();
        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
        int[] nums;
        int k;

        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            // Calculate ksum: the sum of each k-length subarray
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i >= k - 1) {
                    ksum.add(sum);
                    sum -= nums[i - k + 1];
                }
            }
            return getIndices();
        }

        private int getMaxSum(int i, int cnt) {
            if (cnt == 3 || i > nums.length - k) {
                return 0;
            }
            var key = new Pair<>(i, cnt);
            var val = dp.get(key);
            if (val != null) return val;

            //include
            var include = ksum.get(i) + getMaxSum(i + k, cnt + 1);
            //skip
            var skip = getMaxSum(i + 1, cnt);
            dp.put(key, Math.max(include, skip));
            return dp.get(key);
        }

        private int[] getIndices() {
            int i = 0;
            List<Integer> l = new ArrayList<>();
            while (i <= nums.length - k && l.size() < 3) {
                var include = ksum.get(i) + getMaxSum(i + k, l.size() + 1);
                var skip = getMaxSum(i + 1, l.size());

                if (include >= skip) {
                    l.add(i);
                    i += k;
                } else {
                    i += 1;
                }
            }
            int[] indices = new int[] {l.get(0), l.get(1), l.get(2)};
            return indices;
        }
    }
}
