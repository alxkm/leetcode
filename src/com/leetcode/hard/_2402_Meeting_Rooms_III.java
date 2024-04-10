package com.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2402_Meeting_Rooms_III {
    //https://leetcode.com/problems/meeting-rooms-iii/
    //2402. Meeting Rooms III
    //union find

    public static class Pair {
        int[] first;
        int[] second;
        public Pair(int[] f, int[] s) {
            this.first = f;
            this.second = s;
        }
    }

    public int mostBooked1(int n, int[][] meetings) {
        PriorityQueue<int[]> rpq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        for (int i = 0; i < n; i++) {
            rpq.offer(new int[]{i, 0});
        }
        PriorityQueue<Pair> mpq = new PriorityQueue<>((x, y) -> x.second[1] - y.second[1]);
        int t = 0;
        for (int[] m : meetings) {
            if (!rpq.isEmpty()) {
                int[] r = rpq.poll();
                r[1]++;
                m[0] += t;
                m[1] += t;
                mpq.offer(new Pair(r, m));
            } else {
                t = mpq.peek().second[1];
                while (!mpq.isEmpty() && mpq.peek().second[1] <= m[0] + t) {
                    rpq.offer(mpq.poll().first);
                }
                var room = rpq.poll();
                room[1]++;
                m[0] += t;
                m[1] += t;
                mpq.offer(new Pair(room, m));
            }
        }

        while (!mpq.isEmpty()) {
            rpq.offer(mpq.poll().first);
        }

        PriorityQueue<int[]> rooms = new PriorityQueue<>((x, y) -> (x[1] != y[1]) ? y[1] - x[1] : x[0] - y[0]);
        while (!rpq.isEmpty()) {
            rooms.offer(rpq.poll());
        }
        return rooms.poll()[0];
    }


    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)-> (x[1] == y[1]) ? x[0] - y[0] : x[1] - y[1]);
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.offer(i);
        int[] ans = new int[n];

        for (int[] m : meetings) {
            while (!pq.isEmpty() && pq.peek()[1] <= m[0]) {
                free.offer(pq.poll()[0]);
            }

            if (free.isEmpty()) {
                int[] prev = pq.poll();
                int room = prev[0];
                int t = prev[1];
                ans[room]++;
                pq.offer(new int[] {room, t + (m[1] - m[0])});
            } else {
                int room = free.poll();
                ans[room]++;
                pq.offer(new int[] {room, m[1]});
            }
        }
        int max = Arrays.stream(ans).max().getAsInt();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == max){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        var sol = new _2402_Meeting_Rooms_III();
        int[][] m = new int[][] {{0,10},{1,5},{2,7},{3,4}};
        //System.out.println(sol.mostBooked(2, m));
        int[][] m1 = new int[][] {{18,19},{3,12},{17,19},{2,13},{7,10}};
        System.out.println(sol.mostBooked(4, m1));

//        int[][] m2 = new int[][] {{0,10},{1,9},{2,8},{3,7},{4,6}};
//        System.out.println(sol.mostBooked(3, m2));
    }
}
