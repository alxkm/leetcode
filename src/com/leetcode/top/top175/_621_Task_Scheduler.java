package com.leetcode.top.top175;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class _621_Task_Scheduler {
    //https://leetcode.com/problems/task-scheduler/
    //621. Task Scheduler
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

    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (char t: tasks) map.put(t, map.getOrDefault(t, 0) + 1);

        int counter = 0;

        do {
            int c = 0;
            Set<Character> set = new HashSet<>();
            for (var entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    set.add(entry.getKey());
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
                counter++;
                c++;
                if (c == n + 1) break;
            }
            for (Character character : set) {
                map.remove(character);
            }
            if (map.size() > 0 && c < n + 1) counter += n + 1 - c;
        } while (map.size() != 0);

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _621_Task_Scheduler();
        //System.out.println(sol.leastInterval1(new char[] {'A','A','A','B','B','B'}, 2));
        System.out.println(sol.leastInterval1(new char[] {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2));
        //System.out.println(sol.leastInterval1(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 1));
    }
}
