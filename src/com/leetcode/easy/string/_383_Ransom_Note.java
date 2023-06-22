package com.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

public class _383_Ransom_Note {
    //https://leetcode.com/problems/ransom-note/

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch: ransomNote.toCharArray()) {
            var count = map.get(ch);
            if (count == null || count == 0) return false;
            map.put(ch, count - 1);
        }
        return true;
    }
}
