package com.leetcode.medium.simulation;

import com.leetcode.Pair;

import java.util.HashSet;
import java.util.Set;

public class _874_Walking_Robot_Simulation {
    //874. Walking Robot Simulation
    //https://leetcode.com/problems/walking-robot-simulation/description/

    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDistance = 0;
        Set<Pair<Integer, Integer>> obs = new HashSet<>();
        for (int[] ar: obstacles) {
            obs.add(new Pair<>(ar[0], ar[1]));
        }
        char cur = 'N';
        for (int i = 0, j = 0, k = 0; k < commands.length; k++) {
            int c = commands[k];
            if (c > 0) {
                int dx = 0;
                int dy = 0;

                if (cur == 'N') {
                    dy = 1;
                } else if (cur == 'E') {
                    dx = 1;
                } else if (cur == 'S') {
                    dy = -1;
                } else if (cur == 'W') {
                    dx = -1;
                }

                while (c > 0) {
                    if (!obs.contains(new Pair<>(i + dx, j + dy))) {
                        i += dx;
                        j += dy;
                        maxDistance = Math.max(maxDistance, i * i + j * j);
                    } else {
                        break;
                    }
                    c--;
                }
            } else if (c == -1) {
                if (cur == 'N') cur = 'E';
                else if (cur == 'E') cur = 'S';
                else if (cur == 'S') cur = 'W';
                else if (cur == 'W') cur = 'N';
            } else if (c == -2) {
                if (cur == 'N') cur = 'W';
                else if (cur == 'W') cur = 'S';
                else if (cur == 'S') cur = 'E';
                else if (cur == 'E') cur = 'N';
            }
            maxDistance = Math.max(maxDistance, i * i + j * j);
        }

        return maxDistance;
    }
}
