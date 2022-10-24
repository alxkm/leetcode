package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class _2053_Kth_Distinct_String_in_an_Array {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer a = map.get(arr[i]);
            if (a != null) map.put(arr[i], ++a);
            else map.put(arr[i], 1);
        }

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) counter++;
            if (counter == k) return arr[i];
        }

        return "";
    }
}
