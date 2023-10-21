package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class _2657_Find_the_Prefix_Common_Array_of_Two_Arrays {

    //https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
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

}
