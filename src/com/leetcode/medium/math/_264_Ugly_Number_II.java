package com.leetcode.medium.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _264_Ugly_Number_II {
    //264. Ugly Number II
    //https://leetcode.com/problems/ugly-number-ii/description/
    //FOREIGN_SOLUTION
    //TODO

    public int nthUglyNumber(int n) {
        Set<Integer> used = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int i = n;
        while (i > 0) {

            int cur = pq.poll();
            if (used.contains(cur)) continue;
            used.add(cur);

            int a = cur * 2;
            int b = cur * 3;
            int c = cur * 5;

            pq.add(a);
            pq.add(b);
            pq.add(c);

            i--;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        var sol = new _264_Ugly_Number_II();

        System.out.println(sol.nthUglyNumber(38));
    }
}
