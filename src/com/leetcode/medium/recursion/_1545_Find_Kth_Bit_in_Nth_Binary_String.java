package com.leetcode.medium.recursion;

public class _1545_Find_Kth_Bit_in_Nth_Binary_String {
    //1545. Find Kth Bit in Nth Binary String
    //https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/

    int[] ar = new int[21];
    public char findKthBit(int n, int k) {
        if (k == 1) return '0';
        ar[1] = 1;
        for (int i = 2; i < 21; i++) ar[i] = 2 * ar[i - 1] + 1;

        return f(n, k) == 1 ? '1' : '0';
    }


    private int f(int n, int k) {
        if (ar[n - 1] + 1 == k) return 1;
        if (n == 2) return "011".toCharArray()[k - 1] - '0';
        if (ar[n - 1] >= k) return f(n - 1, k);

        int firstPartSize = ar[n - 1] + 1;
        k -= firstPartSize;
        int newK = Math.abs(k - ar[n - 1]) + 1;
        return (f(n - 1, newK) == 1) ? 0 : 1;
    }
}
