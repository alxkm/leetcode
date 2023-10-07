package com.leetcode.medium.dp;

import java.util.Arrays;

public class _279_Perfect_Squares {
    //https://leetcode.com/problems/perfect-squares/
    //FOREIGN_SOLUTION
    //TOP

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int target = 1; target < n + 1; target++) {
            for (int s = 1; s < target + 1; s++) {
                int square = s * s;
                if (target - square < 0) break;
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[n];
    }


/*
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int target = 1; target < n + 1; target++) {
            System.out.println("target = " + target);
            for (int s = 1; s < target + 1; s++) {
                int square = s * s;
                System.out.println("square = " + square);
                System.out.println("exit  = " + (target - square < 0));
                if (target - square < 0) break;
                System.out.println("(target - square) = " + (target - square));
                System.out.println("dp[target - square] = " + dp[target - square]);
                System.out.println("dp[target] = " + dp[target] + "             1 + dp[target - square] = " + (1 + dp[target - square]));
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
        return dp[n];
    }
*/

    public static void main(String[] args) {
        var sol = new _279_Perfect_Squares();
        sol.numSquares(12);
    }
}
