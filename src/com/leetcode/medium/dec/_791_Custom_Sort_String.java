package com.leetcode.medium.dec;

import java.util.HashMap;
import java.util.Map;

public class _791_Custom_Sort_String {
    //https://leetcode.com/problems/custom-sort-string/
    //791. Custom Sort String

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: order.toCharArray()) {
            Integer q = map.get(ch);
            if (q != null) {
                for (int i = 0; i < q; i++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (var e: map.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    public String customSortString1(String order, String s) {
        int[] ord = new int[100];
        for (char ch: s.toCharArray()) ord[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char ch: order.toCharArray()) {
            if (ord[ch - 'a'] != 0) {
                int size = ord[ch - 'a'];
                for (int i = 0; i < ord[ch - 'a']; i++) {
                    sb.append(ch);
                }
                ord[ch - 'a'] = 0;
            }
        }
        for (int i = 0; i < ord.length; i++) {
            if (ord[i] != 0) {
                for (int j = 0; j < ord[i]; j++) {
                    sb.append((char)('a' + i));
                }

            }
        }
        return sb.toString();
    }
}
