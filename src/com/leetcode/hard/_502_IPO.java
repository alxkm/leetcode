package com.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _502_IPO {
    //502. IPO
    //https://leetcode.com/problems/ipo/description/

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            ar[i][0] = capital[i];
            ar[i][1] = profits[i];
        }

        Arrays.sort(ar, (x, y) -> {
            if (x[0] == y[0]) return y[1] - x[1];
            return x[0] - y[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        while (k > 0) {
            while (i < n && ar[i][0] <= w) {
                pq.add(ar[i][1]);
                i++;
            }
            if (pq.isEmpty()) break;
            w += pq.poll();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        var sol = new _502_IPO();
        System.out.println(sol.findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0, 1, 1}));
    }
}
