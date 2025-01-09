package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2744_Find_Maximum_Number_of_String_Pairs {
    //2744. Find Maximum Number of String Pairs
    //https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/

    public int maximumNumberOfStringPairs(String[] words) {
        List<int[]> l = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (var w : words) {
            int[] ch = new int[26];
            for (int i = 0; i < w.length(); i++) {
                ch[w.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                sb.append("i_" + ch[i]);
            }
            int prevPairsCounter = map.getOrDefault(sb.toString(), 0);
            map.put(sb.toString(), prevPairsCounter + 1);
        }

        int pairs = 0;
        for (var kv : map.entrySet()) {
            if (kv.getValue() > 1) {
                pairs += kv.getValue() - 1;
            }
        }
        return pairs;
    }

    //FOREIGN SOLUTION

    public int maximumNumberOfStringPairs1(String[] words) {
        int pairs = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].charAt(0) == s.charAt(1) && words[j].charAt(1) == s.charAt(0))
                    pairs++;
            }
        }
        return pairs;
    }
}
