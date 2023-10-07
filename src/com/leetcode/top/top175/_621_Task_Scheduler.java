package com.leetcode.top.top175;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _621_Task_Scheduler {
    //https://leetcode.com/problems/task-scheduler/
    //FOREIGN_SOLUTION
    //TOP

    class Pair {
        int remainTime;
        int next;
        Pair (int remainTime, int next) {
            this.remainTime = remainTime;
            this.next = next;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int cnt[] = new int[26];
        for (char c: tasks) {
            cnt[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.add(cnt[i]);
            }
        }
        Queue<Pair> q = new LinkedList<>();
        int time = 0;
        while (pq.size() > 0 || q.size() > 0) {
            time++;
            if (pq.size() > 0) {
                int cur = pq.poll();
                cur--;
                if (cur > 0) {
                    q.add(new Pair(cur, time + n));
                }
            }
            if (q.size() > 0 && q.peek().next == time && q.peek().remainTime > 0) {
                Pair d = q.poll();
                pq.add(d.remainTime);
            }
        }
        return time;
    }
}
