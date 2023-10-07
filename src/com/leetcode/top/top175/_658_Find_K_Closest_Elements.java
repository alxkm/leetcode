package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.List;

public class _658_Find_K_Closest_Elements {
    //https://leetcode.com/problems/find-k-closest-elements/
    //FOREIGN_SOLUTION
    //binary search
    //TOP

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int l = 0, r = arr.length - k;

        while (l < r) {
            int m = (l + r) / 2;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        for (int i = l; i < l + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
