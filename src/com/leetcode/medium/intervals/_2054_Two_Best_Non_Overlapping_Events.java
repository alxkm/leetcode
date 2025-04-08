package com.leetcode.medium.intervals;

import com.leetcode.ArrayUtil;
import com.leetcode.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2054_Two_Best_Non_Overlapping_Events {
    //2054. Two Best Non-Overlapping Events
    //https://leetcode.com/problems/two-best-non-overlapping-events/description/

    public static int maxTwoEvents(int[][] events) {
        //Create a PriorityQueue to store the pair ending time and value.
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getKey)
        );

        //Sort the array in ascending order
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxVal = 0, maxSum = 0;

        for (int[] event : events) {
            // Poll all valid events from queue and take their maximum.
            while (!pq.isEmpty() && pq.peek().getKey() < event[0]) {
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + event[2]);
            pq.add(new Pair<>(event[1], event[2]));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxTwoEvents(ArrayUtil.to2d("[[1,2,10],[3,4,1],[4,6,100]]")));
    }
}
