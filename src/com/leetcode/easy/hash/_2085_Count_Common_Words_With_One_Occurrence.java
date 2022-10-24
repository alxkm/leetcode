package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _2085_Count_Common_Words_With_One_Occurrence {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        for (String item : words1) {
            Integer a = map.get(item);
            if (a != null) map.put(item, ++a);
            else map.put(item, 1);
        }

        for (String value : words2) {
            Integer a = map1.get(value);
            if (a != null) map1.put(value, ++a);
            else map1.put(value, 1);
        }
        int counter = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {

            if (e.getValue() == 1) {
                var s = map1.get(e.getKey());
                if (s != null && s == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
