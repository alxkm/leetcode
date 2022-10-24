package com.company.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2032_Two_Out_of_Three {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> n = check(nums1, nums2);
        n.addAll(check(nums1, nums3));
        n.addAll(check(nums2, nums3));
        return new ArrayList<>(n);
    }

    private Set<Integer> check(int[] nums1, int[] nums2) {
        Set<Integer> n = new HashSet<>();

        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    n.add(k);
                }
            }
        }
        return n;
    }

}
