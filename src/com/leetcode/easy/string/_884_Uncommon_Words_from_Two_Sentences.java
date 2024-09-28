package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _884_Uncommon_Words_from_Two_Sentences {
    //884. Uncommon Words from Two Sentences
    //https://leetcode.com/problems/uncommon-words-from-two-sentences/description/?envType=daily-question&envId=2024-09-17

    static public String[] uncommonFromSentences(String s1, String s2) {
        String[] sArr = s1.split(" ");
        String[] sArr2 = s2.split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(sArr));
        List<String> l1 = new ArrayList<>(Arrays.asList(sArr));
        List<String> l2 = new ArrayList<>(Arrays.asList(sArr2));
        set.retainAll(Arrays.asList(sArr2));
        l1.removeAll(set);
        l2.removeAll(set);
        List<String> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);

        return l.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }

    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map = new HashMap<>();
            String[] strs = s1.split(" ");
            for (var s: strs) {
                s = s.trim();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            List<String> ar = new ArrayList<>();
            strs = s2.split(" ");
            for (var s: strs) {
                s = s.trim();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            for (var e: map.entrySet()) {
                if (e.getValue() == 1) {
                    ar.add(e.getKey());
                }
            }
            String[] strAr = new String[ar.size()];
            for (int i = 0; i < ar.size(); i++) {
                strAr[i] = ar.get(i);
            }
            return strAr;
        }
    }
}
