package com.leetcode.easy.design;

import com.leetcode.ArrayUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _703_Kth_Largest_Element_in_a_Stream {
    //https://leetcode.com/problems/kth-largest-element-in-a-stream/description/?envType=daily-question&envId=2024-08-12
    //703. Kth Largest Element in a Stream

    static class KthLargest {
        private Queue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                queue.offer(n);
            }
        }

        public int add(int val) {
            List<Integer> l = new LinkedList<Integer>();
            int kth = val;
            for (int i = 0; i < k; i++) {
                kth = queue.poll();
                l.add(kth);
            }
            for (Integer n : l) {
                queue.offer(n);
            }
            // int kth = l.get(l.size() - k - 1);
            queue.offer(val);
            return kth;
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    public static void main(String[] args) {
        var sol = new KthLargest(3, ArrayUtil.of(4,5,8,2));
        sol.add(3);
        sol.add(5);
        sol.add(10);
        System.out.println(sol);
    }
    class KthLargest1 {
        private Queue<Integer> pq = new PriorityQueue<>();
        private int k;

        public KthLargest1(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                pq.offer(n);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
