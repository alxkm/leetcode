package com.leetcode.medium.priorityqueue;

import java.util.PriorityQueue;

public class _1792_Maximum_Average_Pass_Ratio {
    //1792. Maximum Average Pass Ratio
    //https://leetcode.com/problems/maximum-average-pass-ratio/description/?envType=daily-question&envId=2024-12-15

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> Double.compare(improvement(y[0], y[1]), improvement(x[0], x[1])));

        for (int[] ar : classes) {
            pq.offer(ar);
        }

        while (extraStudents-- > 0) {
            int[] ar = pq.poll();
            ar[0]++;
            ar[1]++;
            pq.offer(ar);
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            int[] ar = pq.poll();
            sum += (double) ar[0] / ar[1];
        }
        return sum / classes.length;
    }

    private double improvement(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
