package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2965_Find_Missing_and_Repeated_Values {
    //https://leetcode.com/problems/find-missing-and-repeated-values/description/
    //2965. Find Missing and Repeated Values

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        List<Integer> d = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        for (int[] ar: grid) {
            for (int a: ar) {
                if (!set.add(a)) d.add(a);
            }
        }
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!set.contains(i)) {
                m.add(i);
            }
        }
        int[] ar = new int[d.size() + m.size()];
        int i = 0;

        for (int a: d) {
            ar[i++] = a;
        }

        for (int a: m) {
            ar[i++] = a;
        }
        return ar;
    }

    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        boolean[] check = new boolean[grid.length * grid[0].length + 1];
        int[] ans = new int[2];
        for (int[] ar : grid) {
            for (int i = 0; i < grid.length; i++) {
                if (check[ar[i]]) {
                    ans[0] = ar[i];
                } else {
                    check[ar[i]] = true;
                }
            }
        }
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
