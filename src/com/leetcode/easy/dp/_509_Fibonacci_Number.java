package com.company.dp;

public class _509_Fibonacci_Number {
    public int fib(int n) {
        if (n == 0) return 0;
        int a = 0;
        int b = 1;
        int i = 1;
        while (++i <= n) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
