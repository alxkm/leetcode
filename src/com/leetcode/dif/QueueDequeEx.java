package com.leetcode.dif;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDequeEx {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);

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

    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                d.offer(i);
            } else {
                r.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            var curD = d.poll();
            var curR = r.poll();

            if (curD < curR) {
                d.offer(curD);
            } else {
                r.offer(curR);
            }
        }
        if (r.isEmpty())
            return "Dire";
        return "Radiant";
    }

    public static void main(String[] args) {
        var sol = new QueueDequeEx();
        System.out.println(sol.predictPartyVictory("RDD"));
    }
}
