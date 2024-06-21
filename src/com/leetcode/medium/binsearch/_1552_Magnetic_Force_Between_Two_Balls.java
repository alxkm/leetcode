package com.leetcode.medium.binsearch;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _1552_Magnetic_Force_Between_Two_Balls {
    //1552. Magnetic Force Between Two Balls
    //https://leetcode.com/problems/magnetic-force-between-two-balls/description
    //FOREIGN_SOLUTION

    // Check if we can place 'm' balls at 'position'
    // with each ball having at least 'x' gap.
    private boolean canPlaceBalls(int x, int[] position, int m) {
        // Place the first ball at the first position.
        int prevBallPos = position[0];
        int ballsPlaced = 1;

        // Iterate on each 'position' and place a ball there if we can place it.
        for (int i = 1; i < position.length && ballsPlaced < m; ++i) {
            int currPos = position[i];
            // Check if we can place the ball at the current position.
            if (currPos - prevBallPos >= x) {
                ballsPlaced += 1;
                prevBallPos = currPos;
            }
        }
        // If all 'm' balls are placed, return 'true'.
        return ballsPlaced == m;
    }

    public int maxDistance(int[] position, int m) {
        int answer = 0;
        int n = position.length;
        Arrays.sort(position);

        // Initial search space.
        int low = 1;
        int high = (int) Math.ceil(position[n - 1] / (m - 1.0));
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // If we can place all balls having a gap at least 'mid',
            if (canPlaceBalls(mid, position, m)) {
                // then 'mid' can be our answer,
                answer = mid;
                // and discard the left half search space.
                low = mid + 1;
            } else {
                // Discard the right half search space.
                high = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        var sol = new _1552_Magnetic_Force_Between_Two_Balls();
        System.out.println(sol.maxDistance(ArrayUtil.of(1, 2, 3, 4, 7), 3));
    }
}
