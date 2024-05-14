package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _815_Bus_Routes {
    //815. Bus Routes
    //https://leetcode.com/problems/bus-routes/

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int n: routes[i]) {
                if (graph.get(n) == null) {
                    graph.put(n, new ArrayList<>());
                }
                graph.get(n).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        for (int route: graph.get(source)) {
            q.offer(route);
            visit.add(route);
        }
        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int curRoute = q.poll();

                for (int route: routes[curRoute]) {
                    if (route == target) return busCount;

                    for (int newRoute: graph.get(route)) {
                        if (!visit.contains(newRoute)) {
                            visit.add(newRoute);
                            q.offer(newRoute);
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}
