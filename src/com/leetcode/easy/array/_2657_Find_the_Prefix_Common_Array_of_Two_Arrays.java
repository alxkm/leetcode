package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class _2657_Find_the_Prefix_Common_Array_of_Two_Arrays {
    //https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
    //https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14
    //2657. Find the Prefix Common Array of Two Arrays

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] dp = new int[A.length];
        int c = 0;
        for (int i = 0; i < A.length; i++) {
            set1.add(A[i]);
            set2.add(B[i]);
            if (A[i] == B[i]) {
                c++;
            } else {
                if (set1.contains(B[i]) && set2.contains(A[i])) {
                    c += 2;
                } else if (set1.contains(B[i]) || set2.contains(A[i])) {
                    c++;
                }
            }
            dp[i] = c;
        }
        return dp;
    }

    public int[] findThePrefixCommonArray1(int[] A, int[] B) {
        boolean[] set1 = new boolean[51];
        boolean[] set2 = new boolean[51];
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length && i < B.length; i++) {
            set1[A[i]] = true;
            set2[B[i]] = true;

            int counter = 0;
            for (int j = 0; j < 51; j++) {
                if (set1[j] && set1[j] == set2[j]) counter++;
            }

            ans[i] = counter;
        }
        return ans;
    }
}
