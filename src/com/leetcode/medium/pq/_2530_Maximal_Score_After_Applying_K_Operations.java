package com.leetcode.medium.pq;

import java.util.PriorityQueue;
import java.util.Queue;

public class _2530_Maximal_Score_After_Applying_K_Operations {
    //2530. Maximal Score After Applying K Operations
    //https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/

    public long maxKelements(int[] nums, int k) {
        long score = 0l;
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (var n: nums) pq.offer(n);

        while (k > 0) {
            int n = pq.poll();
            pq.offer((int)Math.ceil((double)n / 3.0));
            score += n;
            k--;
        }
        return score;
    }
}
