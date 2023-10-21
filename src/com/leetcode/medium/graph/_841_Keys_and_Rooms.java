package com.leetcode.medium.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841_Keys_and_Rooms {
    //841. Keys and Rooms
    //https://leetcode.com/problems/keys-and-rooms/
    //top
    //not_optimal
    //dfs

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (n == 0) return true;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];

        for (int key: rooms.get(0)) {
            q.offer(key);
        }

        while (!q.isEmpty()) {
            int key = q.poll();
            if (visit[key]) continue;
            visit[key] = true;
            for (int k: rooms.get(key)) {
                q.offer(k);
            }
        }

        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) n--;
        }

        return (n == 0 || (n == 1 && !visit[0]));
    }

}
