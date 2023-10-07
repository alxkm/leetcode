package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _986_Interval_List_Intersections {
    //https://leetcode.com/problems/interval-list-intersections/
    //FOREIGN_SOLUTION
    //TOP

    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> l = new ArrayList<>();
        if (a.length == 0) return new int[0][0];
        for (int i = 0, j = 0; i < a.length && j < b.length;) {
            if (a[i][1] < b[j][0]) {
                i++;
            } else if (b[j][1] < a[i][0]) {
                j++;
            } else {
                l.add(new int[]{Math.max(a[i][0], b[j][0]), Math.min(a[i][1], b[j][1])});
                if (a[i][1] > b[j][1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return l.toArray(new int[l.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}},
                secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        var solution = new _986_Interval_List_Intersections();
        System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList, secondList)));
    }
}
