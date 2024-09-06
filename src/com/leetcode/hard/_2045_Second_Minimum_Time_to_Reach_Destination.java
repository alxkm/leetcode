package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2045_Second_Minimum_Time_to_Reach_Destination {
    //2045. Second Minimum Time to Reach Destination
    //https://leetcode.com/problems/second-minimum-time-to-reach-destination/description/

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
        for (int[] ed: edges) {
            adj[ed[0]].add(ed[1]);
            adj[ed[1]].add(ed[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int curTime = 0;
        int ans = -1;
        List<Integer>[] visitTimes = new ArrayList[n + 1]; //node -> [visit]
        for (int i = 0; i <= n; i++) visitTimes[i] = new ArrayList<Integer>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == n) {
                    if (ans != -1) {
                        return curTime;
                    }
                    ans = curTime;
                }

                for (var nei: adj[node]) {
                    var neiTimes = visitTimes[nei];
                    if (neiTimes.size() == 0 || (neiTimes.size() == 1 && neiTimes.get(0) != curTime)) {
                        q.add(nei);
                        neiTimes.add(curTime);
                    }
                }
            }

            if ((curTime / change) % 2 == 1) {
                curTime += change - (curTime % change);
            }
            curTime += time;
        }

        return 0;
    }
}
