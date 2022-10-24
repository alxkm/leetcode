package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1436_Destination_City {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

        for (List<String> l : paths) {
            map.put(l.get(0), l.get(1));
        }
        String s = paths.get(0).get(0);
        for (int i = 0; i < paths.size(); i++) {
            String n = map.get(s);
            if (n == null) break;
            s = n;
        }
        return s;
    }
}
