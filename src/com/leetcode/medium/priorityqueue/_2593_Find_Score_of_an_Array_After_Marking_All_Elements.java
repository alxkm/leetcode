package com.leetcode.medium.priorityqueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _2593_Find_Score_of_an_Array_After_Marking_All_Elements {
    //2593. Find Score of an Array After Marking All Elements
    //https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/

    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        long score = 0;
        Set<Integer> set = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] ar = pq.poll();
            if (set.contains(ar[1])) continue;
            score += ar[0];
            set.add(ar[1]);
            set.add(ar[1] - 1);
            set.add(ar[1] + 1);
        }
        return score;
    }
}
