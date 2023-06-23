package com.leetcode.easy.matrix;

import java.math.BigInteger;

public class _1175_Prime_Arrangements {
    //https://leetcode.com/problems/prime-arrangements/

    private static final BigInteger MOD = BigInteger.valueOf(1000000007);
    public int numPrimeArrangements(int n) {
        int primes = countPrime(n);
        BigInteger x = factorial(primes);
        BigInteger y = factorial(n - primes);
        BigInteger counter = x.multiply(y);
        return counter.mod(MOD).intValue();
    }

    private BigInteger factorial(int n) {
        BigInteger a = BigInteger.ONE;
        while (n > 1) {
            a = a.multiply(BigInteger.valueOf(n));
            n--;
        }
        return a.mod(MOD);
    }

    private int countPrime(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) counter++;
        }
        return counter;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }
}
