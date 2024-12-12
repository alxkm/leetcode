package com.leetcode.easy.pq;

import com.leetcode.ArrayUtil;

import java.util.PriorityQueue;

public class _2558_Take_Gifts_From_the_Richest_Pile {
    //2558. Take Gifts From the Richest Pile
    //https://leetcode.com/problems/take-gifts-from-the-richest-pile/?envType=daily-question&envId=2024-12-12
    //https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/?envType=daily-question&envId=2024-12-12

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int n: gifts) pq.offer(n);
        long sum = 0;
        while (k > 0) {
            int n = pq.poll();
            pq.offer((int)Math.sqrt(n));
            k--;
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(pickGifts(ArrayUtil.of(25,64,9,4,100), 4));
    }
}
