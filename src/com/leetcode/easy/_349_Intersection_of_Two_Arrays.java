package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class _349_Intersection_of_Two_Arrays {
    //349. Intersection of Two Arrays
    //https://leetcode.com/problems/intersection-of-two-arrays/

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> s = new HashSet<>();
            for (int v : nums1) {
                s.add(v);
            }
            Set<Integer> s1 = new HashSet<>();
            for (int v : nums2) {
                s1.add(v);
            }

            s.retainAll(s1);

            int[] a = new int[s.size()];
            int i = 0;
            for (Integer v : s) {
                a[i++] = v;
            }
            return a;
        }
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] counterNums2 = new int[1001];
        for (int n: nums2) counterNums2[n]++;

        boolean[] inter = new boolean[1001];
        int size = 0;
        for (int n: nums1) {
            if (counterNums2[n] > 0 && !inter[n]) {
                inter[n] = true;
                size++;
            }
        }
        int[] ar = new int[size];

        for (int i = 0, j = 0; i < inter.length; i++) {
            if (inter[i]) ar[j++] = i;
        }

        return ar;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //Output: [9,4]
    }
}
