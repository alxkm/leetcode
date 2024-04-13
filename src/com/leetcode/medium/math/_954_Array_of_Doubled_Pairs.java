package com.leetcode.medium.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _954_Array_of_Doubled_Pairs {
    //954. Array of Doubled Pairs
    //https://leetcode.com/problems/array-of-doubled-pairs/

    public boolean canReorderDoubled(int[] arr) {
        if (arr.length % 2 != 0) return false;
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int number : arr) {
            counterMap.put(number, counterMap.getOrDefault(number, 0) + 1);
        }
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, Comparator.comparingInt(Math::abs));

        for (Integer x : a) {
            if (counterMap.get(x) == 0) continue;

            if (counterMap.getOrDefault(2 * x, 0) <= 0) return false;

            counterMap.put(x, counterMap.get(x) - 1);
            counterMap.put(2 * x, counterMap.get(2 * x) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new _954_Array_of_Doubled_Pairs();
        System.out.println(sol.canReorderDoubled(new int[]{-2,-4,2,4}));
        System.out.println(sol.canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(sol.canReorderDoubled(new int[]{2,4,0,0,8,1}));
    }
}
