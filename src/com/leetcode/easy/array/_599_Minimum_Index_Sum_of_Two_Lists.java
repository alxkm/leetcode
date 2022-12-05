package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599_Minimum_Index_Sum_of_Two_Lists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] search = list1.length < list2.length ? list1 : list2;
        String[] mapArray = list1.length < list2.length ? list2 : list1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < mapArray.length; i++) map.put(mapArray[i], i);
        int min = search.length + mapArray.length;
        boolean is = false;
        for (int i = 0; i < search.length; i++) {
            if (map.get(search[i]) != null && (map.get(search[i]) + i) < min) {
                min = map.get(search[i]) + i;
                is = true;
            }
        }
        List<String> list = new ArrayList<>();
        if (is) {
            for (int i = 0; i < search.length; i++) {
                if (map.get(search[i]) != null
                        && (map.get(search[i]) + i) == min) {
                    list.add(search[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
