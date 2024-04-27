package com.leetcode.easy.binarysearch;

public class _1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    //1351. Count Negative Numbers in a Sorted Matrix
    //https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
    //binarySearch

    public int countNegatives(int[][] grid) {
        int counter = 0;

        for (int[] ints : grid) {
            for (int j = ints.length - 1; j >= 0; j--) {
                if (ints[j] < 0) {
                    counter++;
                } else {
                    break;
                }
            }
        }

        return counter;
    }

    public int countNegatives1(int[][] grid) {
        int cnt = 0;
        for (int[] ar: grid) {
            int l = 0, r = ar.length - 1;

            int flag = -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (ar[m] < 0) {
                    flag = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            for (int i = (flag == - 1) ? 0 : l; i < ar.length && ar[i] < 0; i++) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        var sol = new _1351_Count_Negative_Numbers_in_a_Sorted_Matrix();
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(sol.countNegatives1(grid));
    }
}
