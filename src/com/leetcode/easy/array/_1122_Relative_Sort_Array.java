package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _1122_Relative_Sort_Array {
    //1122. Relative Sort Array
    //https://leetcode.com/problems/relative-sort-array/description/

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] order = new int[1003];
        Arrays.fill(order, 1000000);
        for (int i = 0; i < arr2.length; i++) order[arr2[i]] = i;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (order[i] == 1003) list.add(arr1[i]);
        }
        Collections.sort(list);

        int[] ar = Arrays.stream(arr1).boxed().sorted((x, y) -> {
            if (order[x] == order[y]) return x - y;
            return order[x] - order[y];
        }).mapToInt(i -> i).toArray();

        for (int i = arr1.length - list.size(), j = 0; i < arr1.length; i++, j++) {
            arr1[i] = list.get(j);
        }
        return ar;
    }

    static public int[] relativeSortArray(int[] arr1, int[] arr2) {
        var n = new HashMap<Integer, Integer>();
        var l = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        var tailList = new ArrayList<Integer>();
        for (Integer i : arr1) {
            if (l.contains(i)) {
                n.put(i, n.getOrDefault(i, 0) + 1);
            } else {
                tailList.add(i);
            }
        }
        int j = 0;
        for (int a : arr2) {
            var b = n.get(a);

            if (b != null) {
                for (int k = 0; k < b; k++) {
                    arr1[j] = a;
                    j++;
                }
            }
        }
        var sortedTailList = tailList.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < tailList.size(); i++) {
            arr1[j] = sortedTailList.get(i);
            j++;
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,3,2,4,6,7,9,2,19};
        int[] b = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(a, b)));
    }
}
