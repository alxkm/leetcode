package com.leetcode.medium.math;

public class _779_K_th_Symbol_in_Grammar {
    //https://leetcode.com/problems/k-th-symbol-in-grammar/description/
    //779. K-th Symbol in Grammar

    public int kthGrammar(int n, int k) {
        return f(0, n, k);
    }

    public int f(int change, int n, int k) {
        System.out.println();
        System.out.println("change = " + change);
        System.out.println("n = " + n);
        System.out.println("k = " + k);

        if (n == 1) return 0;
        if (n == 2) {
            int pow = (int) Math.pow(2, n);
            int half = pow / 2;
            int newK = getNewK(k, pow, half);
            if (newK < k) change++;

            int a = (k == 1) ? 0 : 1;

            for (int i = change; i > 0; i--) {
                if (a == 0) a = 1;
                else a = 0;
            }
            return a;
        }
        int pow = (int) Math.pow(2, n);
        int half = pow / 2;
        int newK = getNewK(k, pow, half);
        System.out.println("half = " + half);
        System.out.println("pow = " + pow);
        System.out.println("newK = " + newK);

        if (newK < k) change++;
        return f(change, n - 1, newK);
    }

    private int getNewK(int k, int pow, int half) {
        return (k > half) ? (half - (pow - k)) : k;
    }

    public static void main(String[] args) {
        var sol = new _779_K_th_Symbol_in_Grammar();
        System.out.println(sol.kthGrammar(3, 5));
    }

}
