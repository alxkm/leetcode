package com.leetcode.easy.dp;

public class _1646_Get_Maximum_in_Generated_Array {
    static public int getMaximumGenerated(int n) {
        if (n < 2) return n;

        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if ((2 * i) >= 2 && (i * 2) <= n) {
                a[i * 2] = a[i];
            }
            if ((2 * i + 1) >= 2 && (i * 2 + 1) <= n) {
                a[i * 2 + 1] = a[i] + a[i + 1];
            }
            max = Math.max(a[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }
}
