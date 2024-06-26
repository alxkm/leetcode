package com.leetcode.easy.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2215_Find_the_Difference_of_Two_Arrays {
    //https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
    //2215. Find the Difference of Two Arrays
    //easyTop

    static public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var s1 = new HashSet<Integer>();
        var s2 = new HashSet<Integer>();
        var s3 = new HashSet<Integer>();

        for (Integer i : nums1) {
            s1.add(i);
            s3.add(i);
        }
        for (Integer i : nums2) {
            s2.add(i);
        }

        for (Integer i : s3) {
            if (s2.contains(i)) {
                s1.remove(i);
                s2.remove(i);
            }
        }

        var l1 = new ArrayList<>(s1);
        var l2 = new ArrayList<>(s2);

        List<List<Integer>> l3 = new ArrayList<>();
        l3.add(l1);
        l3.add(l2);
        return l3;
    }

    public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums1) set.add(n);
        Set<Integer> seen = new HashSet<>();
        List<Integer> second = new ArrayList<>();
        for (int n: nums2) {
            if (!set.remove(n) && !seen.contains(n)) {
                second.add(n);
            }
            seen.add(n);
        }
        List<Integer> first = new ArrayList<>(set);
        return List.of(first, second);
    }

    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int n: nums1) s1.add(n);
        for (int n: nums2) s2.add(n);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int n: s1) {
            if (!s2.contains(n)) {
                l1.add(n);
            }
        }

        for (int n: s2) {
            if (!s1.contains(n)) {
                l2.add(n);
            }
        }
        return List.of(l1, l2);
    }

    public static void main(String[] args) {
        int [][] nums  = {
                {1,2,3,3},
                {1,1,2,2}
        };

        System.out.println(findDifference(nums[0], nums[1]));
    }
}
