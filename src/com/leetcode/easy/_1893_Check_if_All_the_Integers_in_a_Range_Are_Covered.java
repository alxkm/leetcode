package com.leetcode.easy;

public class _1893_Check_if_All_the_Integers_in_a_Range_Are_Covered {
    static public boolean isCovered(int[][] ranges, int left, int right) {
        int[] points = new int[Math.abs(left - right) == 0 ? 1 : Math.abs(left - right) + 1];
        if (left - right == 0) {
            points[0] = left;
        } else {
            for (int i = left, j = 0; i <= right; i++, j++) {
                points[j] = i;
            }
        }
        for (int point : points) {
            boolean in = false;
            for (int[] range : ranges) {
                if (range[0] <= point && point <= range[1]) {
                    in = true;
                    break;
                }
            }
            if (!in) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums =
                {
                        {1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},
                        {8,8},{9,9},{10,10},{11,11},{12,12},{13,13},
                        {14,14},{15,15},{16,16},{17,17},{18,18},{19,19},
                        {20,20},{21,21},{22,22},{23,23},{24,24},{25,25},
                        {26,26},{27,27},{28,28},{29,29},{30,30},{31,31},
                        {32,32},{33,33},{34,34},{35,35},{36,36},{37,37},
                        {38,38},{39,39},{40,40},{41,41},{42,42},{43,43},
                        {44,44},{45,45},{46,46},{47,47},{48,48},{49,49}
                };

        boolean covered = isCovered(nums, 1, 50);

        System.out.println(covered);
    }
}
