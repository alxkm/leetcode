package com.leetcode.medium.binsearch;

import com.leetcode.ArrayUtil;

public class _1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
    //1482. Minimum Number of Days to Make m Bouquets
    //https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
    //FOREIGN_SOLUTION

    // Return the number of maximum bouquets that can be made on day mid.
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            // If the flower is bloomed, add to the set. Else reset the count.
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                numOfBouquets++;
                count = 0;
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDays = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }

    public static void main(String[] args) {
        var sol = new _1482_Minimum_Number_of_Days_to_Make_m_Bouquets();

        System.out.println(sol.minDays(ArrayUtil.of(1,10,3,10,2), 3, 1));
    }
}
