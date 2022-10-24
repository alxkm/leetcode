package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _2399_Check_Distances_Between_Same_Letters {
    static public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int ch = (int)s.charAt(i) - 97;
            var pos = map.get(ch);
            if (pos != null) {
                int index = Math.abs(i - pos - 1);
                if (pos + 1 == i || i + 1 == pos) map.put(ch, 0);
                else map.put(ch, index);
            } else {
                map.put(ch, i);
            }
        }

        for (int i = 0; i < distance.length; i++) {
            Integer value = map.get(i);
            if (value != null && map.get(i) != distance[i] ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] a = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(checkDistances(s, a));
    }
}
