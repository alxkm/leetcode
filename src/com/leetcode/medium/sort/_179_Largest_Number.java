package com.leetcode.medium.sort;

import java.util.Arrays;
import java.util.Objects;

public class _179_Largest_Number {
    //https://leetcode.com/problems/largest-number/
    //179. Largest Number
    //top
    //https://leetcode.com/problems/largest-number/description/?envType=daily-question&envId=2024-09-18

    public String largestNumber(int[] nums) {
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, (x, y) -> (String.valueOf(x) + y).compareTo(String.valueOf(y) + x));

        StringBuilder sb = new StringBuilder();
        for (int i = nums1.length - 1; i >= 0; i--) {
            sb.append(nums1[i]);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

    public String largestNumber1(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }
        Arrays.sort(ints, (x, y) -> {
            if (Objects.equals(x, y)) return 0;
            String s1 = String.valueOf(x);
            String s2 = String.valueOf(y);
            var t = s1;
            s1 = s1 + s2;
            s2 = s2 + t;

            int i = 0, j = 0;
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) > s2.charAt(j)) {
                    return 1;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    if (i + 1 < s1.length() && j + 1 == s2.length()) {
                        if (s1.charAt(i + 1) != 0) return 1;
                    }
                    if (j + 1 < s2.length() && i + 1 == s1.length()) {
                        if (s2.charAt(j + 1) != 0) return -1;
                    }
                } else {
                    return -1;
                }
                i++;
                j++;
            }

            return -1;
        });
        StringBuilder sb = new StringBuilder();

        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(ints[i]);
        }

        return (sb.toString().charAt(0) == '0') ? "0" : sb.toString();
    }
}
