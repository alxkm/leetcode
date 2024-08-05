package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2053_Kth_Distinct_String_in_an_Array {
    //2053. Kth Distinct String in an Array
    //https://leetcode.com/problems/kth-distinct-string-in-an-array/?envType=daily-question&envId=2024-08-05

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (var s: arr) {
            if (map.get(s) == 1) k--;
            if (k == 0) return s;
        }

        return "";
    }
}
