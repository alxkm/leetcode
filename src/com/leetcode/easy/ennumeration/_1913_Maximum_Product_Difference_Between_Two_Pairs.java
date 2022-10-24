package com.leetcode.easy.ennumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1913_Maximum_Product_Difference_Between_Two_Pairs {
    static public int maxProductDifference(int[] nums) {
        int max = -1000000;
        int max1 = -1000000;
        int min = 1000000;
        int min1 = 1000000;

        List<Integer> l = new ArrayList<>(nums.length);
        for (int j : nums) {
            l.add(j);
        }
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        l.remove(Integer.valueOf(max));
        l.remove(Integer.valueOf(min));

        for (int num : l) {
            max1 = Math.max(max1, num);
            min1 = Math.min(min1, num);
        }
        return ((max * max1) - (min * min1));
    }

    public static void main(String[] args) {
        int[] a = {5,9,4,6};

        System.out.println(maxProductDifference(a));
    }
}
