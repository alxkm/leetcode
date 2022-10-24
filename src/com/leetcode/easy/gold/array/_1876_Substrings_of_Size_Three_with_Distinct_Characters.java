package com.company.gold.array;

import java.util.HashSet;
import java.util.Set;

public class _1876_Substrings_of_Size_Three_with_Distinct_Characters {
    static public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));
            if (set.size() == 3) cnt++;

            set.remove(s.charAt(i));
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
