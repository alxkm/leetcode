package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _210_Course_Schedule_II {
    //https://leetcode.com/problems/course-schedule-ii/
    //210. Course Schedule II
    //FOREIGN_SOLUTION
    //TOP

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());

        for (int[] c: prerequisites) {
            List<Integer> a = map.get(c[0]);
            a.add(c[1]);
            map.put(c[0], a);
        }

        List<Integer> order = new ArrayList<>();
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() == 0) {
                order.add(entry.getKey());
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (map.get(i) == null) order.add(i);
        }
        for (int i: order) map.remove(i);

        if (order.size() == 0) return new int[]{};

        boolean[] visit = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visit[i]) {
                if (!dfs(i, map, visit, order, new HashSet<Integer>())) {
                    return new int[]{};
                }
            }
        }
        if (order.size() != numCourses) {
            return new int[]{};
        }
        int[] l = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            l[i] = order.get(i);
        }

        return l;
    }

    private boolean dfs(int cur, Map<Integer, List<Integer>> map, boolean[] visit, List<Integer> order,
                        Set<Integer> set) {
        if (set.contains(cur)) {
            return false;
        }

        if (visit[cur] || map.get(cur) == null ) {
            return true;
        }
        set.add(cur);
        for (int n: map.get(cur)) {
            if (!dfs(n, map, visit, order, set)) return false;

        }
        set.remove(cur);
        if (!order.contains(cur)) {
            order.add(cur);
        }
        visit[cur] = true;
        return true;
        //map.remove(cur);
    }

    public static void main(String[] args) {
        var solution = new _210_Course_Schedule_II();
        int[][] a = {{1,0},
                {0,3},
                {0,2},
                {3,2},
                {2,5},
                {4,5},
                {5,6},
                {2,4}};

        System.out.println(Arrays.toString(solution.findOrder(7, a)));
    }
}
