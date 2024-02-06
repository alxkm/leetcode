package com.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {
    //49. Group Anagrams
    //https://leetcode.com/problems/group-anagrams/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] newArray = Arrays.copyOf(str.toCharArray(), str.toCharArray().length);
            Arrays.sort(newArray);
            StringBuilder sb = new StringBuilder();
            for (char ch: newArray) {
                sb.append(ch);
            }
            var list = map.getOrDefault(sb.toString(), new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String str = new String(s);
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            str = new String(ch);
            if (map.get(str) == null) map.put(str, new ArrayList<>());
            map.get(str).add(s);
        }
        List<List<String>> ll = new ArrayList<>();
        for (var l: map.values()) ll.add(l);
        return ll;
    }
}
