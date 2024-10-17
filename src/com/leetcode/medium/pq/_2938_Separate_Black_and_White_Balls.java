package com.leetcode.medium.pq;

import java.util.PriorityQueue;

public class _2938_Separate_Black_and_White_Balls {
    //2938. Separate Black and White Balls
    //https://leetcode.com/problems/separate-black-and-white-balls/description/

    public long minimumSteps(String s) {
        long score = 0;
        char[] ch = s.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int j = ch.length - 1; j >= 0; j--) {
            if (ch[j] == '0') {
                pq.offer(j);
            } else {
                if (pq.isEmpty()) continue;
                score += pq.poll() - j;
                pq.offer(j);
            }
        }
        return score;
    }
}
