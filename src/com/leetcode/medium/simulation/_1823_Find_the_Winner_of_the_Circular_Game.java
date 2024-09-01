package com.leetcode.medium.simulation;

import java.util.LinkedList;
import java.util.Queue;

public class _1823_Find_the_Winner_of_the_Circular_Game {
    //1823. Find the Winner of the Circular Game
    //https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) q.add(i);
        int i = 0;
        while (q.size() != 1) {
            int a = q.poll();
            if (++i == k) {
                q.remove(i);
                i = 0;
            } else {
                q.offer(a);
            }
        }

        return q.poll();
    }

    public int findTheWinner1(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.add(i);
        int i = 0;
        while (q.size() != 1) {
            int a = q.poll();
            if (++i == k) {
                i = 0;
                System.out.println(q);
            } else {
                q.offer(a);
            }
        }

        return q.poll();
    }

    public static void main(String[] args) {
        var sol = new _1823_Find_the_Winner_of_the_Circular_Game();
        System.out.println(sol.findTheWinner(5, 2));
    }
}
