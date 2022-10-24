package com.company.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer a = map.get(arr[i]);
            if (a != null) map.put(arr[i], ++a);
            else map.put(arr[i], 1);
        }

        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) return false;
            set.add(entry.getValue());
        }
        return true;
    }
}
