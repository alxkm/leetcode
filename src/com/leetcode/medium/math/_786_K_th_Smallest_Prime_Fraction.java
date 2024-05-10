package com.leetcode.medium.math;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _786_K_th_Smallest_Prime_Fraction {
    //786. K-th Smallest Prime Fraction
    //https://leetcode.com/problems/k-th-smallest-prime-fraction/description/

    class Triple {
        float a;
        int b;
        int c;

        public Triple(float a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Triple[] narr = new Triple[arr.length * arr.length - arr.length];

        for (int i = 0, t = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                Triple tr = new Triple(((float)arr[i] / (float)arr[j]), arr[i], arr[j]);
                narr[t] = tr;
                t++;
            }
        }

        Arrays.sort(narr, (o1, o2) -> Float.compare(o1.a, o2.a));
        int[] ints = {narr[k - 1].b, narr[k - 1].c};
        return ints;
    }

    public static void main(String[] args) {
        var sol = new _786_K_th_Smallest_Prime_Fraction();
        System.out.println(Arrays.toString(sol.kthSmallestPrimeFraction(ArrayUtil.of(1, 2, 3, 5), 3)));
    }
}
