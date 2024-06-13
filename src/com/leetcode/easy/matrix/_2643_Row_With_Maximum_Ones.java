package com.leetcode.easy.matrix;

public class _2643_Row_With_Maximum_Ones {
    //2643. Row With Maximum Ones
    //https://leetcode.com/problems/row-with-maximum-ones/

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];

        int row = 0;
        for (int[] ar: mat) {
            int cnt = 0;
            for (int n: ar) {
                if (n == 1) cnt++;
            }
            if (cnt > ans[1]) {
                ans[0] = row;
                ans[1] = cnt;
            }
            row++;
        }
        return ans;
    }
}
