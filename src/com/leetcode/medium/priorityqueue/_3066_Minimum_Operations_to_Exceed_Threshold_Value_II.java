package com.leetcode.medium.priorityqueue;

import java.util.PriorityQueue;

public class _3066_Minimum_Operations_to_Exceed_Threshold_Value_II {
    //3066. Minimum Operations to Exceed Threshold Value II
    //https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: nums) {
            if (n < k) {
                pq.offer(n);
            }
        }
        int q = 0;

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x >= k && y >= k) break;
            int cur = Math.min(x, y) * 2 + Math.max(x, y);
            if (cur >= k) continue;
            pq.offer(cur);
            q++;
        }

        return q;
    }
}
