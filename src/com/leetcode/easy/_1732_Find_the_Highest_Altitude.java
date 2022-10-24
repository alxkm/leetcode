package com.company;

public class _1732_Find_the_Highest_Altitude {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int max = 0;

        for (int j : gain) {
            start += j;
            max = Math.max(max, start);
        }

        return max;
    }
}
