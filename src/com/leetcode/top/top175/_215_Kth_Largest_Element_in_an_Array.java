package com.leetcode.top.top175;

import java.util.PriorityQueue;
import java.util.Queue;

public class _215_Kth_Largest_Element_in_an_Array {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    //215. Kth Largest Element in an Array
    //FOREIGN_SOLUTION
    //TOP

    public int findKthLargest1(int[] nums, int k) {
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

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int a, int b) {
        if (a == b) return nums[a];

        int m = nums[(a + b) / 2];
        int i = a, j = b;

        while (i <= j) {
            while (nums[i] > m) i++;
            while (nums[j] < m) j--;

            if (i >= j) break;

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        int newA = a, newB = b, newK = k;

        if (k <= (j - a + 1)) {
            newA = a;
            newB = j;
            newK = k;
        } else {
            newA = j + 1;
            newB = b;
            newK = k - (j - a + 1);
        }

        return findKthLargest(nums, newK, newA, newB);
    }

    public static void main(String[] args) {
        var sol = new _215_Kth_Largest_Element_in_an_Array();
        sol.findKthLargest(new int[] {3,2,1,5,6,4}, 2);
    }
}
