package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {
    //https://leetcode.com/problems/find-all-duplicates-in-an-array/
    //442. Find All Duplicates in an Array

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            //System.out.println("i = " + i);
            //System.out.println(Arrays.toString(nums));

            int correctIndex = nums[i] - 1;
            if (i != correctIndex && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else i++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                l.add(nums[i]);
            }
        }

        return l;
    }


    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("INIT");
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (n != nums[n]) {
                int tmp = nums[n];
                nums[n] = n;
                n = tmp;
                System.out.println(Arrays.toString(nums));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                l.add(nums[i + 1]);
            }
        }
        return l;
    }

    public List<Integer> findDuplicates4(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            int correctIndex = nums[i] - 1;
            System.out.println("i = " + i);
            System.out.println(Arrays.toString(nums));
            if (i != correctIndex && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                l.add(nums[i]);
            }
        }
        return l;
    }
























    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("INIT");
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (n != nums[n]) {
                int tmp = nums[n];
                nums[n] = n;
                n = tmp;
                System.out.println(Arrays.toString(nums));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                l.add(nums[i + 1]);
            }
        }
        return l;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            int correctIndex = nums[i] - 1;
            System.out.println("i = " + i);
            System.out.println(Arrays.toString(nums));
            if (i != correctIndex && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                l.add(nums[i]);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        var sol = new _442_Find_All_Duplicates_in_an_Array();
        System.out.println(sol.findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
