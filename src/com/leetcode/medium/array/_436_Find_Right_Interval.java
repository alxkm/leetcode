package com.leetcode.medium.array;

import java.util.Arrays;

public class _436_Find_Right_Interval {
    //https://leetcode.com/problems/find-right-interval/
    //436. Find Right Interval

    public int[] findRightInterval(int[][] intervals) {
        int[][] ar = new int[intervals.length][3];

        for (int i = 0; i < intervals.length; i++) {
            ar[i][0] = intervals[i][0];
            ar[i][1] = intervals[i][1];
            ar[i][2] = i;
        }

        Arrays.sort(ar, (a, b) -> a[0] - b[0]);
        int[] ans = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            ans[i] = -1;
            for (int j = 0; j < ar.length; j++) {
                if (ar[j][0] >= intervals[i][1]) {
                    ans[i] = ar[j][2];
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {3,4},{2,3},{1,2}
        };

        var sol = new _436_Find_Right_Interval();
        System.out.println(Arrays.toString(sol.findRightInterval(a)));
    }
}
