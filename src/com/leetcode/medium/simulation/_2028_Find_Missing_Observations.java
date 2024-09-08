package com.leetcode.medium.simulation;

import java.util.Arrays;

public class _2028_Find_Missing_Observations {
    //2028. Find Missing Observations
    //https://leetcode.com/problems/find-missing-observations/description/

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int subSum = 0;
        for (int num: rolls) subSum += num;

        int m = rolls.length;

        int total = n + m;

        int totalSum = total * mean;

        int diff = totalSum - subSum;

        int mean1 = diff / n;

        int r = diff % n;

        if (mean1 <= 0 || mean1 > 6 || (mean1 == 6 && r > 0)) return new int[]{};

        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = mean1;
            if (r > 0) {
                ar[i]++;
                r--;
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        var sol = new _2028_Find_Missing_Observations();
        System.out.println(Arrays.toString(sol.missingRolls(new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}, 2, 53)));
    }
}
