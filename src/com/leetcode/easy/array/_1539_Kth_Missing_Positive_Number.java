package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class _1539_Kth_Missing_Positive_Number {
    //https://leetcode.com/problems/kth-missing-positive-number/

    public static int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 1; i <= arr[arr.length - 1]; i++) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int n: arr) {
            list.add(n);
        }
        set.removeAll(list);
        var l = new ArrayList<>(set);
        return l.get(k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 5;
        int kthPositive = findKthPositive(arr, k);
        System.out.println(kthPositive);
    }
}
