package com.leetcode.medium.prefix;

public class _2391_Minimum_Amount_of_Time_to_Collect_Garbage {
    //2391. Minimum Amount of Time to Collect Garbage
    //https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

    public int garbageCollection(String[] garbage, int[] travel) {
        int gmax = -1, mmax = -1, pmax = -1;
        int total = 0;
        for (int i = 0; i < garbage.length; i++) {
            String str = garbage[i];
            total += str.length();
            if (str.contains("G")) {
                gmax = Math.max(gmax, i);
            }
            if (str.contains("M")) {
                mmax = Math.max(mmax, i);
            }
            if (str.contains("P")) {
                pmax = Math.max(pmax, i);
            }
        }

        for (int i = 1; i < garbage.length; i++) {
            if (i <= gmax && gmax != -1) {
                total += travel[i - 1];
            }
            if (i <= mmax && mmax != -1) {
                total += travel[i - 1];
            }
            if (i <= pmax && pmax != -1) {
                total += travel[i - 1];
            }
        }

        return total;
    }
}
