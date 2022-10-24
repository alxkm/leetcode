package com.leetcode.easy.string.additional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1624_Largest_Substring_Between_Two_Equal_Characters {
    static public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            var list = map.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            map.put(ch, list);
        }
        int max = -1;
        for (var entry : map.entrySet()) {
            var l = entry.getValue();

            if (l.size() == 1) continue;
            max = Math.max(max, Math.abs(l.get(0) + 1 - l.get(l.size() - 1)));
        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "ygtqdztaduxlsaacrwgtewywwchlnqzgjxhqgdhybncgaifonbe";
        String s =
                "mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(maxLengthBetweenEqualCharacters(s));

    }
}
