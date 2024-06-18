package com.leetcode.medium.greedy;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _826_Most_Profit_Assigning_Work {
    //826. Most Profit Assigning Work
    //https://leetcode.com/problems/most-profit-assigning-work

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }
        Arrays.sort(dp, (x, y) -> {
            return y[1] - x[1];
        });
        int s = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j][0] <= worker[i]) {
                    s += dp[j][1];
                    break;
                }
            }
        }
        return s;
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }
        Arrays.sort(dp, (x, y) -> y[1] - x[1]);
        Arrays.sort(worker);
        int s = 0;
        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            if (dp[j][0] > worker[i]) {
                j++;
            } else {
                s += dp[j][1];
                i--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        var sol = new _826_Most_Profit_Assigning_Work();
        //System.out.println(sol.maxProfitAssignment1(ArrayUtil.of(2, 4, 6, 8, 10), ArrayUtil.of(10, 20, 30, 40, 50), ArrayUtil.of(4, 5, 6, 7)));
        System.out.println(sol.maxProfitAssignment1(ArrayUtil.of(68,35,52,47,86), ArrayUtil.of(67,17,1,81,3), ArrayUtil.of(92,10,85,84,82)));
    }
}
