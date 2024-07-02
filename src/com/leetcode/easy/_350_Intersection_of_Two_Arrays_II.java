package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350_Intersection_of_Two_Arrays_II {
    //350. Intersection of Two Arrays II
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

    static public int[] intersect(int[] nums1, int[] nums2) {
        var l1 = new ArrayList<Integer>(nums1.length);
        var l2 = new ArrayList<Integer>(nums2.length);

        for (int i : nums1) {
            l1.add(i);
        }
        for (int i : nums2) {
            l2.add(i);
        }

        var l3 = new ArrayList<Integer>();
        for (Integer i : l1) {
            if (l2.contains(i)) {
                l3.add(i);
            }
            l2.remove(i);
        }
        var l4 = new int[l3.size()];

        for (int i = 0; i < l4.length; i++) {
            l4[i] = l3.get(i);
        }
        return l4;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        int[] in1 = new int[1001];
        int[] in2 = new int[1001];

        for (int n: nums1) in1[n]++;
        for (int n: nums2) {
            if (in1[n] > 0) {
                in2[n]++;
                in1[n]--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < in2.length; i++) {
            for (int j = 0; j < in2[i]; j++) {
                list.add(i);
            }
        }
        int[] ar = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ar[i] = list.get(i);
        }
        return ar;
    }

    public static void main(String[] args) {
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
