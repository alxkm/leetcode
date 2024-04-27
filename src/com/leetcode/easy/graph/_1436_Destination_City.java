package com.leetcode.easy.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1436_Destination_City {
    //1436. Destination City
    //https://leetcode.com/problems/destination-city/description/

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

    public String destCity1(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (var l: paths) {
            set.add(l.get(0));
        }
        for (var l: paths) {
            if (set.add(l.get(1))) return l.get(1);
        }
        return "";
    }
}
