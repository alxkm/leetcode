package com.leetcode.easy.top.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays {
    //1460. Make Two Arrays Equal by Reversing Subarrays
    //https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/?envType=daily-question&envId=2024-08-03

    public boolean canBeEqual(int[] target, int[] arr) {
         Map<Integer, Integer> m1 = new HashMap<>();
         Map<Integer, Integer> m2 = new HashMap<>();

         if (target.length != arr.length) return false;

        for (int j : target) m1.put(j, m1.getOrDefault(j, 0) + 1);
        for (int j : arr) m2.put(j, m2.getOrDefault(j, 0) + 1);

         for (var entry : m1.entrySet()) {
             var valueMap2 = m2.get(entry.getKey());
             if ((valueMap2 != null ) && (entry.getValue() <= m2.get(entry.getKey()))) continue;
             return false;
         }

         return true;
    }


    public boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }


    public boolean canBeEqual2(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m != n) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map.put(b[i], map.getOrDefault(b[i], 0) - 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) != 0) return false;
        }
        return true;
    }

    public boolean canBeEqual3(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            if(target[i] != arr[i]){
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual4(int[] target, int[] arr) {
        int[] ar1 = new int[1001];
        int[] ar2 = new int[1001];

        for (int i = 0; i < target.length; i++) {
            ar1[target[i]]++;
            ar2[arr[i]]++;
        }

        for (int i = 0; i < 1001; i++) {
            if (ar1[i] != ar2[i]) return false;
        }
        return true;
    }

    public boolean canBeEqual5(int[] target, int[] arr) {
        int[] ar1 = new int[1001];
        int[] ar2 = new int[1001];
        int max = -1;
        for (int i = 0; i < target.length; i++) {
            ar1[target[i]]++;
            ar2[arr[i]]++;
            max = Math.max(max, Math.max(target[i], arr[i]));
        }

        for (int i = 0; i <= max; i++) {
            if (ar1[i] != ar2[i]) return false;
        }
        return true;
    }
}
