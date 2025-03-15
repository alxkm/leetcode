package com.leetcode.medium.dp;

import java.util.Arrays;

public class _983_Minimum_Cost_For_Tickets {
    //983. Minimum Cost For Tickets
    //https://leetcode.com/problems/minimum-cost-for-tickets/description/
    //FOREIGN

    class Solution {
        int[] days;
        int[] costs;
        int[] memo;

        public int mincostTickets(int[] days, int[] costs) {
            this.days = days;
            this.costs = costs;
            memo = new int[days.length];
            Arrays.fill(memo, -1);
            return f(0);
        }

        private int f(int i) {
            if (i >= days.length) return 0;
            if (memo[i] != -1) return memo[i];

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < costs.length; j++) {
                int duration = (j == 0) ? 1 : (j == 1) ? 7 : 30;
                int curDate = i;
                while (curDate < days.length && days[curDate] < days[i] + duration) {
                    curDate++;
                }
                min = Math.min(min, costs[j] + f(curDate));
            }
            return memo[i] = min;
        }
    }
}
