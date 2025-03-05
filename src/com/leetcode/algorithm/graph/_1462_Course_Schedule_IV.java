package com.leetcode.algorithm.graph;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1462_Course_Schedule_IV {
    //https://leetcode.com/problems/course-schedule-iv/description/
    //1462. Course Schedule IV

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] gr = new List[numCourses];
        List<Integer>[] back = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            gr[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        for (int[] ar : prerequisites) {
            int u = ar[0];
            int v = ar[1];
            gr[v].add(u);
            back[u].add(v);
        }

        int j = 0;
        boolean[] is = new boolean[queries.length];
        for (int[] qv : queries) {

            int u = qv[0];
            int v = qv[1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(v);
            while (!q.isEmpty()) {
                int t = q.poll();

                for (int g : back[t]) {
                    q.add(g);
                    if (u == g) {
                        is[j] = true;
                        break;
                    }
                }
                if (is[j]) {
                    break;
                }
            }
            j++;
        }
        List<Boolean> b = new ArrayList<>();
        for (boolean a : is) {
            b.add(a);
        }

        return b;
    }

    public static void main(String[] args) {
        var t = checkIfPrerequisite(2, ArrayUtil.to2d("[[1,0]]"), ArrayUtil.to2d("[[0,1],[1,0]]"));
    }
}
