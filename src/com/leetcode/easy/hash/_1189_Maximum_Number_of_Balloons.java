package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _1189_Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : text.toCharArray()) {
            Integer i = map.get(ch);
            if (i != null) {
                map.put(ch, ++i);
            } else {
                map.put(ch, 1);
            }
        }
        boolean is = true;
        int counter = 0;
        while (is) {
            for (Character ch : "balloon".toCharArray()) {
                Integer c = map.get(ch);
                if (c != null && c > 0) {
                    map.put(ch, --c);
                    continue;
                }
                is = false;
            }
            if (is) counter++;
        }
        return counter;
    }
}
