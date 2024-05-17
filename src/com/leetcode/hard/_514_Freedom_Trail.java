package com.leetcode.hard;

import java.util.Arrays;

public class _514_Freedom_Trail {
    //514. Freedom Trail
    //https://leetcode.com/problems/freedom-trail/description/

    public int findRotateSteps1(String ring, String key) {
        char[] s = ring.toCharArray();
        int counter = key.length();
        int start = 0;
        for (char ch : key.toCharArray()) {
            //try to find symbol from cur position in clockwise
            int clockwiseIndex = -1;
            int clockWiseCounter = 0;
            for (int i = start; i < s.length; i++) {
                if (s[i] == ch) {
                    clockwiseIndex = i;
                    break;
                }
                clockWiseCounter++;
            }
            if (clockwiseIndex == -1) {
                for (int i = 0; i < start; i++) {
                    if (s[i] == ch) {
                        clockwiseIndex = i;
                        break;
                    }
                    clockWiseCounter++;
                }
            }

            //try to find symbol from cur position in contr clockwise
            int notClockwiseIndex = -1;
            int notClockWiseCounter = 0;
            for (int i = start; i >= 0; i--) {
                if (s[i] == ch) {
                    notClockwiseIndex = i;
                    break;
                }
                notClockWiseCounter++;
            }
            if (notClockwiseIndex == -1) {
                for (int i = s.length - 1; i >= 0; i--) {
                    if (s[i] == ch) {
                        notClockwiseIndex = i;
                        break;
                    }
                    notClockWiseCounter++;
                }
            }

            if (clockWiseCounter <= notClockWiseCounter) {
               start = clockwiseIndex;
               counter += clockWiseCounter;
            } else {
                start = notClockwiseIndex;
                counter += notClockWiseCounter;
            }
        }
        return counter;
    }

    char[] s;
    char[] k;
    int[][] dp;

    public int findRotateSteps(String ring, String key) {
        s = ring.toCharArray();
        k = key.toCharArray();
        dp = new int[s.length][s.length];
        for (int[] d : dp) Arrays.fill(d, -1);
        return f(0, 0);
    }

    private int f(int i, int j) {
        if (j == k.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int curOptimalDistance = Integer.MAX_VALUE;
        for (int l = 0; l < s.length; l++) {
            if (s[l] == k[j]) {
                int minDistance = Math.min(Math.abs(i - l), s.length - Math.abs(i - l));
                curOptimalDistance = Math.min(curOptimalDistance, minDistance + 1 + f(l, j + 1));
            }
        }
        dp[i][j] = curOptimalDistance;
        return curOptimalDistance;
    }

    public static void main(String[] args) {
        var sol = new _514_Freedom_Trail();
        System.out.println(sol.findRotateSteps("godding", "godding"));
    }
}
