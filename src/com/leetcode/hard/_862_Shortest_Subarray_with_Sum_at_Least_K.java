package com.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

public class _862_Shortest_Subarray_with_Sum_at_Least_K {
    //862. Shortest Subarray with Sum at Least K
    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            while (!deque.isEmpty() && prefixSums[j] - prefixSums[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, j - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSums[j] <= prefixSums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(j);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
