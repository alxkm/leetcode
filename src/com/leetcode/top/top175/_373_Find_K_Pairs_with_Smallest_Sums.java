package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _373_Find_K_Pairs_with_Smallest_Sums {
    //https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    //373. Find K Pairs with Smallest Sums
    //FOREIGN_SOLUTION
    //TOP

    public static class Pair {
        int first;
        int second;
        int sum;
        public Pair(int f, int s, int sum) {
            this.first = f;
            this.second = s;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Pair> q = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (q.size() < k) {
                    q.offer(new Pair(nums1[i], nums2[j], sum));
                } else {
                    if (sum < q.peek().sum) {
                        q.poll();
                        q.offer(new Pair(nums1[i], nums2[j], sum));
                    } else {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> ll = new ArrayList<>();
        while (k >= 1 && !q.isEmpty()) {
            Pair p = q.poll();
            k--;
            ll.add(List.of(p.first, p.second));
        }
        return ll;
    }

    public static void main(String[] args) {
        //int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        //int k = 3;
        int[] nums1 = {1,1,2}, nums2 = {1,2,3};
        int k = 2;
        var solution = new _373_Find_K_Pairs_with_Smallest_Sums();
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }
}
