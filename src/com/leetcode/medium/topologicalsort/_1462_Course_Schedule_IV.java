package com.leetcode.medium.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class _1462_Course_Schedule_IV {
    //https://leetcode.com/problems/course-schedule-iv/description/
    //1462. Course Schedule IV

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        for (int[] ar : prerequisites) {
            isPrerequisite[ar[0]][ar[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    isPrerequisite[i][j] |= (isPrerequisite[i][k] && isPrerequisite[k][j]);
                }
            }
        }

        List<Boolean> is = new ArrayList<>();
        for (int[] qv : queries) {
            int u = qv[0];
            int v = qv[1];
            is.add(isPrerequisite[u][v]);
        }
        return is;
    }
}
