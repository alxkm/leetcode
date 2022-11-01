package com.leetcode.easy.string.additional;

import java.util.HashMap;
import java.util.Map;

public class _2287_Rearrange_Characters_to_Make_Target_String {
    static public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        int counter = 0;
        while (true) {
            boolean is = true;
            for (var entry : map.entrySet()) {
                var key = map1.get(entry.getKey());
                if (key != null) {
                    int left = map1.get(entry.getKey()) - entry.getValue();
                    if (left >= 0) {
                        map1.put(entry.getKey(), left);
                        continue;
                    }
                    is = false;
                    break;
                } else {
                    is = false;
                }
            }
            if (is) counter++;
            else break;
        }
        return counter;
    }

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "abcd";

        System.out.println(rearrangeCharacters(s, s1));
    }
}
