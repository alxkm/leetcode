package com.leetcode.medium.arrayarray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _448_Find_All_Numbers_Disappeared_in_an_Array {
    //448. Find All Numbers Disappeared in an Array
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != i + 1 && n != -1) {
                nums[i] = -1;
                while (n != -1 && nums[n - 1] != n) {
                    int t = nums[n - 1];
                    nums[n - 1] = n;
                    n = t;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) list.add(i + 1);
        }
        return list;
    }
}
