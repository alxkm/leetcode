package com.leetcode.top.top175;

import java.util.Arrays;

public class _406_Queue_Reconstruction_by_Height {
    //https://leetcode.com/problems/queue-reconstruction-by-height/
    //FOREIGN_SOLUTION
    //TOP

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> x[0] - y[0]);
        int[][] answer = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < 2; j++) {
                answer[i][j] = -1;
            }
        }

        for (int i = 0; i < people.length; i++) {
            int counter = people[i][1];
            for (int j = 0; j < people.length; j++) {
                if (answer[j][0] == -1 && counter == 0) {
                    answer[j][0] = people[i][0];
                    answer[j][1] = people[i][1];
                    break;
                }
                if (answer[j][0] == -1 || answer[j][0] >= people[i][0]) {
                    counter--;
                }
            }
        }
        return answer;
    }
}
