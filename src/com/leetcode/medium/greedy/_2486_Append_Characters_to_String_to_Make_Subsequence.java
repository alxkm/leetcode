package com.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _2486_Append_Characters_to_String_to_Make_Subsequence {
    //2486. Append Characters to String to Make Subsequence
    //https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

    public static int appendCharacters(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int size = t.length();
        //for (int i = 0; i < s1.length; i++) {
        int j = 0, k = 0;
        while (j < t1.length && k < s1.length) {
            if (s1[k] == t1[j]) {
                j++;
            }
            k++;
        }
        if (j == t1.length) {
            return 0;
        }
        size = Math.min(size, t1.length - j);
        //}
        return size;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] order = new int[1002];
        Arrays.fill(order, 100);
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

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }
}
