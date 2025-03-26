package com.leetcode.medium.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2523_Closest_Prime_Numbers_in_Range {
    //https://leetcode.com/problems/closest-prime-numbers-in-range/
    //2523. Closest Prime Numbers in Range

    final static int N = 1_000_000;
    final static boolean[] prime = new boolean[N];

    static {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= N; p++) {
            if (prime[p] == false) continue;
            for (int i = p * p; i < N; i += p) {
                prime[i] = false;
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = Math.max(2, left), j = 0; i <= right && i < N; i++) {
            if (prime[i]) list.add(i);
        }
        if (list.size() < 2) {
            return new int[] { -1, -1 };
        }
        int[] pr = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (minDiff > list.get(i) - list.get(i - 1)) {
                minDiff = list.get(i) - list.get(i - 1);
                pr[0] = list.get(i - 1);
                pr[1] = list.get(i);
            }
        }
        return pr;
    }
}
