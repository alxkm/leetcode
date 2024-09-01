package com.leetcode.easy.array;

public class _3162_Find_the_Number_of_Good_Pairs_I {
    //3162. Find the Number of Good Pairs I
    //https://leetcode.com/problems/find-the-number-of-good-pairs-i/description/

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int counter = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % k != 0) continue;
            for (int j = 0; j< nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) counter++;
            }
        }
        return counter;
    }
}
