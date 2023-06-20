package com.leetcode.easy.math;

public class _1925_Count_Square_Sum_Triples {
    //https://leetcode.com/problems/count-square-sum-triples/

    public int countTriples(int n) {
        int counter = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i*i + j*j == k*k) {
                        counter++;
                    }
                }

            }
        }
        return counter;
    }
}
