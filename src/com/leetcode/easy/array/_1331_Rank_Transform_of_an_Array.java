package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1331_Rank_Transform_of_an_Array {
    //1331. Rank Transform of an Array
    //https://leetcode.com/problems/rank-transform-of-an-array

    public int[] arrayRankTransform(int[] arr) {
        int[] arr1 = new int[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        Arrays.sort(arr1);
        Map<Integer, Integer> map = new HashMap<>();
        int same = 0;
        for (int i = 0; i < arr1.length; i++) {
            var n = map.get(arr1[i]);
            if (n == null) {
                map.put(arr1[i], i + 1 - same);
            } else {
                same++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public int[] arrayRankTransform1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: arr) {
            map.putIfAbsent(n, -1);
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++) {
            map.put(l.get(i), i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        var sol = new _1331_Rank_Transform_of_an_Array();
        System.out.println(Arrays.toString(sol.arrayRankTransform(arr)));
    }
}
