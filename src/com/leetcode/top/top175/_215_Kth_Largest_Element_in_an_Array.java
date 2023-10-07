package com.leetcode.top.top175;

import java.util.PriorityQueue;
import java.util.Queue;

public class _215_Kth_Largest_Element_in_an_Array {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    //FOREIGN_SOLUTION
    //TOP

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        for (int n: nums) q.offer(n);

        int n = q.poll();
        k--;

        while (k > 0) {
            n = q.poll();
            k--;
        }
        return n;
    }
}
