package com.leetcode.medium.array;

import com.leetcode.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1338_Reduce_Array_Size_to_The_Half {
    //1338. Reduce Array Size to The Half
    //https://leetcode.com/problems/reduce-array-size-to-the-half/description/

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[][] ar = new int[map.size()][2];
        int j = 0;
        for (var e : map.entrySet()) {
            ar[j] = new int[2];
            ar[j][0] = e.getKey();
            ar[j][1] = e.getValue();
            j++;
        }
        Arrays.sort(ar, (x, y) -> y[1] - x[1]);

        int size = arr.length / 2;
        int n = 0;
        int counter = 0;
        for (int[] ints : ar) {
            n += ints[1];
            counter++;
            if (n >= size) {
                break;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _1338_Reduce_Array_Size_to_The_Half();
        System.out.println(sol.minSetSize(ArrayUtil.of(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)));
    }
}
