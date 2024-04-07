package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _279_Perfect_Squares {
    //279. Perfect Squares
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

    public int numSquares1(int n) {
        List<Integer> sq = new ArrayList<>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i*i <= n; i++) {
            sq.add(i*i);
            dp[i*i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] == 1) continue;
            for (int j = 0; j < sq.size() && i - sq.get(j) >= 0; j++) {
                dp[i] = Math.min(dp[(i - sq.get(j))] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    public int numSquares2(int n) {
        List<Integer> l = new ArrayList<>();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            l.add(i * i);
            dp[i * i] = 1;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < l.size(); j++) {
                if (i - l.get(j) >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - l.get(j)] + 1);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        var sol = new _279_Perfect_Squares();
        sol.numSquares(12);
    }
}
