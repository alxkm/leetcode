package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class _239_Sliding_Window_Maximum {
    //239. Sliding Window Maximum
    //https://leetcode.com/problems/sliding-window-maximum/

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int n = nums.length;
        int[] ar = new int[n - k + 1];

        for (int i = 0, j = 0; i < n; i++) {
            while (!deq.isEmpty() && deq.peek() < i - k + 1) deq.poll();

            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) deq.pollLast();

            deq.offer(i);
            if (i >= k - 1) ar[j++] = nums[deq.peek()];
        }
        return ar;
    }
}
