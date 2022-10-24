package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350_Intersection_of_Two_Arrays_II {
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

    public static void main(String[] args) {
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
