package com.leetcode.hard;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _632_Smallest_Range_Covering_Elements_from_K_Lists {
    //632. Smallest Range Covering Elements from K Lists
    //https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/

    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            pq.offer(new int[] {nums.get(i).get(0), i, 0});
        }

        int start = pq.peek()[0];
        int end = max;

        while (pq.size() == nums.size()) {
            int[] ar = pq.poll();
            int min = ar[0];
            int i = ar[1];
            int j = ar[2];

            if (end - start > max - min) {
                start = min;
                end = max;
            }

            if (j + 1 < nums.get(i).size()) {
                pq.offer(new int[] {nums.get(i).get(j + 1), i, j + 1});
                max = Math.max(max, nums.get(i).get(j + 1));
            }
        }

        return new int[] {start, end};
    }
}
