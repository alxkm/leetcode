package com.leetcode.medium.hasttable_priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _2342_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
    //https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
    //2342. Max Sum of a Pair With Equal Sum of Digits

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            var pq = map.get(sum);
            if (pq == null) pq = new PriorityQueue<>((x, y) -> y - x);
            pq.offer(nums[i]);
            map.put(sum, pq);
        }

        for (var pq: map.values()) {
            if (pq.size() > 1) {
                max = Math.max(pq.poll() + pq.poll(), max);
            }
        }

        return max;
    }
}
