package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _90_Subsets_II {
    //https://leetcode.com/problems/subsets-ii/

    private final List<List<Integer>> ll = new ArrayList<>();
    private int[] arr;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new LinkedList<>();
        arr = nums;
        f(0, l);
        return ll;
    }

    private void f(int start, List<Integer> l) {
        ll.add(new ArrayList<>(l));
        if (start == arr.length) return;

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            l.add(arr[i]);
            f(i + 1, l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        var solution = new _90_Subsets_II();
        int[] a = {1,2,2};
        System.out.println(solution.subsetsWithDup(a));
    }
}
