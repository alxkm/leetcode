package com.leetcode.easy.matrix;

public class _2614_Prime_In_Diagonal {
    //https://leetcode.com/problems/prime-in-diagonal/

    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i]))
                max = Math.max(max, nums[i][i]);
            if (isPrime(nums[i][n - 1 - i]))
                max = Math.max(max, nums[i][n - 1 - i]);
        }
        return max;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
