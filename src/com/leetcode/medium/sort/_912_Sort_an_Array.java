package com.leetcode.medium.sort;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _912_Sort_an_Array {
    //912. Sort an Array
    //https://leetcode.com/problems/sort-an-array/description/?envType=daily-question&envId=2024-07-25

    public int[] sortArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        mergeSort(list);
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void mergeSort(List<Integer> list) {
        if (list.size() <= 1) return;

        int n = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, n));
        List<Integer> right = new ArrayList<>(list.subList(n, list.size()));

        mergeSort(left);
        mergeSort(right);
        list.clear();
        list.addAll(merge(left, right));
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        int l = 0;
        int r = 0;
        List<Integer> merged = new ArrayList<>();

        while (l < left.size() && r < right.size()) {
            if (left.get(l) <= right.get(r)) {
                merged.add(left.get(l++));
            } else {
                merged.add(right.get(r++));
            }
        }
        while (l < left.size()) {
            merged.add(left.get(l++));
        }
        while (r < right.size()) {
            merged.add(right.get(r++));
        }
        return merged;
    }

    public static void main(String[] args) {
        var sol = new _912_Sort_an_Array();
        System.out.println(Arrays.toString(sol.sortArray(ArrayUtil.of(5, 2, 3, 1))));
    }
}
