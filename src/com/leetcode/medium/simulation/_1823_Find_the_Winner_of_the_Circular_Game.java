package com.leetcode.medium.simulation;

import java.util.LinkedList;
import java.util.Queue;

public class _1823_Find_the_Winner_of_the_Circular_Game {
    //1823. Find the Winner of the Circular Game
    //https://leetcode.com/problems/find-the-winner-of-the-circular-game/

    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int i = 1;
        while (q.size() != 1) {
            if (i == k) {
                i = 1;
                q.poll();
            } else {
                q.offer(q.poll());
                i++;
            }
        }
        return q.poll();
    }
}
