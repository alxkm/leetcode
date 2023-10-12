package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _207_Course_Schedule {
    //207. Course Schedule
    //https://leetcode.com/problems/course-schedule/

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;

        // state 0 = unvisited, 1= visiting and 2= visited.
        int[] state = new int[numCourses];

        for (int[] preq: prerequisites) {
            if (!map.containsKey(preq[0])) map.put(preq[0], new ArrayList<>());
            map.get(preq[0]).add(preq[1]);
        }
        for (int i = 0; i < numCourses; i++)
            if(state[i] == 0 && !dfs(i,state)) return false;

        return true;
    }

    private boolean dfs(int course, int[] state){
        if (state[course] == 1) return false;
        state[course] = 1;
        List<Integer> cur = map.getOrDefault(course,null);
        if (cur == null) {
            state[course] = 2;
            return true;
        }
        for (int preq: cur){
            if (state[preq] == 2) continue;
            if (!dfs(preq, state)) return false;
        }
        state[course] = 2;
        return true;
    }
}
