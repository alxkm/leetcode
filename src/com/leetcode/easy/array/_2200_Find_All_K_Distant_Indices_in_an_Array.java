package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _2200_Find_All_K_Distant_Indices_in_an_Array {
    //https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
    //2200. Find All K-Distant Indices in an Array

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                indexes.add(i);
            }
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j : indexes) {
                if (Math.abs(i - j) <= k) {
                    l.add(i);
                    break;
                }
            }
        }
        return l;
    }
}
