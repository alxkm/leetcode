package com.leetcode.easy.prefix;

import com.leetcode.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

public class _2670_Find_the_Distinct_Difference_Array {
    //2670. Find the Distinct Difference Array
    //https://leetcode.com/problems/find-the-distinct-difference-array/

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        int[] pr = new int[nums.length + 1];
        int[] pr1 = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            pr[i + 1] = pr[i] + (set.add(nums[i]) ? 1 : 0);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            pr1[i] = pr1[i + 1] + (set1.add(nums[i]) ? 1 : 0);
        }

        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] =  pr[i + 1] - pr1[i + 1];
        }
        return diff;
    }
    public int[] distinctDifferenceArray1(int[] nums) {
        boolean[] set = new boolean[110];
        boolean[] set1 = new boolean[110];

        int[] pr = new int[nums.length + 1];
        int[] pr1 = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            pr[i + 1] = pr[i] + (add(set, nums[i]) ? 1 : 0);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            pr1[i] = pr1[i + 1] + (add(set1, nums[i]) ? 1 : 0);
        }

        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] =  pr[i + 1] - pr1[i + 1];
        }
        return diff;
    }

    private boolean add(boolean[] ar, int n) {
        if (n > 0) n = n * -1 + 52;
        boolean exist = ar[n];
        ar[n] = true;
        return !exist;
    }

    public static void main(String[] args) {
        var sol = new _2670_Find_the_Distinct_Difference_Array();
        System.out.println(sol.distinctDifferenceArray(ArrayUtil.of(1, 2, 3, 4, 5)));
    }
}
