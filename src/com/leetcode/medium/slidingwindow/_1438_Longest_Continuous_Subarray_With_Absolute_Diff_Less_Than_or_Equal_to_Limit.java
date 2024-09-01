package com.leetcode.medium.slidingwindow;

import com.leetcode.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    //1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
    //https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
    //FOREIGN_SOLUTION
    //todo todo todo

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int l = 0;
        int r = 0;
        int maxLength  = 0;
        while (r < nums.length) {
            maxHeap.offer(new int[]{nums[r], r});
            minHeap.offer(new int[]{nums[r], r});

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                l = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while (maxHeap.peek()[1] < l) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < l) {
                    minHeap.poll();
                }
            }
            maxLength  = Math.max(maxLength , r - l + 1);
            r++;
        }
        return maxLength;
    }

    public int minKBitFlips(int[] nums, int k) {
        int curWindowFlips = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
           if (i - k >= 0 && nums[i - k] == 2) {
               curWindowFlips--;
           }
           if ((curWindowFlips + nums[i]) % 2  == 0) {
               if (i + k > nums.length) {
                   return -1;
               }

               nums[i] = 2;
               curWindowFlips++;
               counter++;
           }
        }
        return counter;
    }

    public static void main(String[] args) {
        var sol = new _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit();
        System.out.println(sol.longestSubarray(ArrayUtil.of(1, 5, 6, 7, 8, 10, 6, 5, 6), 4));
    }
}
