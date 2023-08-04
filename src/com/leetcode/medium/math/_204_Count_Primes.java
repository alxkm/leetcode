package com.leetcode.medium.math;

public class _204_Count_Primes {
    //https://leetcode.com/problems/count-primes/

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; ++i) {
            if (!primes[i]) {
                counter++;
                for (int j = i + i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        return counter;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new _204_Count_Primes();

        System.out.println(solution.countPrimes(10));
    }
}
