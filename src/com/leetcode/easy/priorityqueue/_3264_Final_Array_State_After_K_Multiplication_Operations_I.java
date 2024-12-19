package com.leetcode.easy.priorityqueue;

import java.util.PriorityQueue;

public class _3264_Final_Array_State_After_K_Multiplication_Operations_I {
    //https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
    //3264. Final Array State After K Multiplication Operations I

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) ->
                x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        for (int i = 0; i < nums.length; i++) pq.offer(new int[] {nums[i], i});

        while (k-- > 0) {
            int[] p = pq.poll();
            nums[p[1]] *= multiplier;
            pq.offer(new int[] {nums[p[1]], p[1]});
        }

        return nums;
    }

    public int[] getFinalState1(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {nums[i], i});
        }
        while (k-- > 0) {
            int[] ar = pq.poll();
            ar[0] = ar[0] * multiplier;
            pq.offer(ar);
            nums[ar[1]] = ar[0];
        }
        return nums;
    }
}
