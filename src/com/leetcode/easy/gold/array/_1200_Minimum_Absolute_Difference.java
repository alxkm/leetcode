package com.company.gold.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200_Minimum_Absolute_Difference {
    static public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = 100000;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, Math.abs(arr[i - 1] - arr[i]));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i - 1] - arr[i]) == min) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i - 1]);
                l.add(arr[i]);
                list.add(l);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1,3,6,10,15};
        System.out.println(minimumAbsDifference(a));
    }
}
