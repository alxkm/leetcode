package com.leetcode.easy;

public class _2413_Smallest_Even_Multiple {
    public int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : n * 2;
    }

//  if n is even, return n << 0
//  if n is odd, return n << 1
//  return n << (n & 1);
}
