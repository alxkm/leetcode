package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class _2418_Sort_the_People {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        int l = 0;
        int size = map.size();
        for (int i = 0; i < size; i++) {
            String value = "";
            int key = 0;
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() > key) {
                    value = entry.getValue();
                    key = entry.getKey();
                }
            }
            names[l++] = value;
            map.remove(key);
        }
        return names;
    }
}
