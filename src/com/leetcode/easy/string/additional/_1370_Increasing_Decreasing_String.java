package com.leetcode.easy.string.additional;

import java.util.HashMap;
import java.util.Map;

public class _1370_Increasing_Decreasing_String {
    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();

        while (sb.length() < s.length()) {
            for (int i = 97; i <= 122; i++) {
                var val = map.getOrDefault((char)i, 0);
                if (val > 0) {
                    sb.append((char)i);
                    map.put((char)i, --val);
                }
            }

            for (int i = 122; i >= 97; i--) {
                var val = map.getOrDefault((char)i, 0);
                if (val > 0) {
                    sb.append((char)i);
                    map.put((char)i, --val);
                }
            }
        }
        return sb.toString();
    }
}
