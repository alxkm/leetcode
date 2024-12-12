package com.leetcode.medium.priorityqueue;

import com.leetcode.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2054_Two_Best_Non_Overlapping_Events {
    //2054. Two Best Non-Overlapping Events
    //https://leetcode.com/problems/two-best-non-overlapping-events/description/

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        Arrays.sort(events, (x, y) -> x[0] - y[0]);
        int maxSum = 0;
        int maxVal = 0;

        for (int[] e: events) {
            while (!pq.isEmpty() && pq.peek().getKey() < e[0]) {
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, e[2] + maxVal);
            pq.offer(new Pair<>(e[1], e[2]));
        }
        return maxSum;
    }
}
