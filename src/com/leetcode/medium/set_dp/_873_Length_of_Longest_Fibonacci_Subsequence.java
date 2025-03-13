package com.leetcode.medium.set_dp;

import java.util.HashSet;
import java.util.Set;

public class _873_Length_of_Longest_Fibonacci_Subsequence {
    //873. Length of Longest Fibonacci Subsequence
    //https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/?envType=daily-question&envId=2025-02-27

    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int prev = arr[i];
                int cur = arr[j];

                int next = prev + cur;

                int len = 2;
                while (set.contains(next)) {
                    prev = cur;
                    cur = next;
                    next = prev + cur;
                    len++;
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        return maxLength;
    }
}
