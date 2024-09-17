package com.leetcode.medium.bitmask;

public class _1310_XOR_Queries_of_a_Subarray {
    //1310. XOR Queries of a Subarray
    //https://leetcode.com/problems/xor-queries-of-a-subarray/description/

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ar = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var q = queries[i];
            int start = q[0];
            int end = q[1];
            int s = arr[start];
            for (int j = start + 1; j <= end; j++) {
                s ^= arr[j];
            }
            ar[i] = s;
        }
        return ar;
    }
}
