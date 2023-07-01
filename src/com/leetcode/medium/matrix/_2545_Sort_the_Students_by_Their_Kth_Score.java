package com.leetcode.medium.matrix;

import java.util.Arrays;

public class _2545_Sort_the_Students_by_Their_Kth_Score {
    //https://leetcode.com/problems/sort-the-students-by-their-kth-score/

    public int[][] sortTheStudents(int[][] score, int k) {
        // Map<Integer, int[]> map = new TreeMap<>(Collections.reverseOrder());
        // for (int[] a: score) {
        //     map.put(a[k], a);
        // }

        // int[][] aa = new int[score.length][score[0].length];

        // int i = 0;
        // for (var entry: map.entrySet()) {
        //     for (int j = 0; j < entry.getValue().length; j++) {
        //         aa[i][j] = entry.getValue()[j];
        //     }
        //     i++;
        // }

        // return aa;
        Arrays.sort(score,(a, b)->b[k]-a[k]);
        return score;
    }
}
