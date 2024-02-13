package com.leetcode.easy.dp;

public class _746_Min_Cost_Climbing_Stairs {
    //https://leetcode.com/problems/min-cost-climbing-stairs/
    //746. Min Cost Climbing Stairs
    //TOP
    //FOREIGN_SOLUTION

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int min = 0;
        for (int i = 0; i < cost.length - 1; i++) {
            int first = cost[i] + ((i + 2) <= cost.length - 1 ? cost[i + 2] : 0);
            int second = cost[i + 1] + ((i + 3) <= cost.length - 1 ? cost[i + 3] : 0);
            if (first < second) {
                i += 2;
                min += first;
                System.out.println("select first " + first);
            } else {
                i += 3;
                min += second;
                System.out.println("select second " + second);
            }
            System.out.println(i);
            if (i + 1 >= cost.length) break;
        }
        return min;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
