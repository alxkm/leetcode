package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1640_Check_Array_Formation_Through_Concatenation {
    //https://leetcode.com/problems/check-array-formation-through-concatenation/

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] ar: pieces) {
            if (ar.length == 1) set.add(ar[0]);
            else map.put(ar[0], ar);
        }

        for (int i = 0; i < arr.length; ) {
            if (set.contains(arr[i])) {
                i++;
                continue;
            } else if (map.get(arr[i]) != null) {
                int[] array = map.get(arr[i]);
                int j = 0;
                while (j < array.length) {
                    if (array[j] != arr[i]) return false;
                    j++;
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ar = {91,4,64,78};
        int[][] pr = {{78},{4,64},{91}};

        System.out.println(canFormArray(ar, pr));
    }
}
