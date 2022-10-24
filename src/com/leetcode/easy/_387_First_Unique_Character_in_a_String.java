package com.company;

import java.util.HashMap;
import java.util.Map;

public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer c = map.get(s.charAt(i));
            if (c != null) {
                map.put(s.charAt(i), ++c);
            } else {
                map.put(s.charAt(i), Integer.valueOf(1));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Integer c = map.get(s.charAt(i));
            if (c == 1) {
                return i;
            }
        }

        return -1;
    }
}
