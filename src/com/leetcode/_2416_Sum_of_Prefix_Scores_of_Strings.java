package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2416_Sum_of_Prefix_Scores_of_Strings {
    //2416. Sum of Prefix Scores of Strings
    //https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/

    public int[] sumPrefixScores(String[] words) {
        List<Set<String>> l = new ArrayList<>();

        for (String s: words) {
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
            l.add(set);
        }
        int[] counters = new int[words.length];
        for (int i = 0; i < counters.length; i++) {
            Set<String> set = l.get(i);
            int counter = 0;
            for (var s: set) {
                for (int j = 0; j < l.size(); j++) {
                    if (j == i) continue;
                    if (l.get(j).contains(s)) counter++;
                }
            }
            counters[i] = counter;
        }
        return counters;
    }

    public static void main(String[] args) {
        var sol = new _2416_Sum_of_Prefix_Scores_of_Strings();
        System.out.println(sol.sumPrefixScores(ArrayUtil.of("abc","ab","bc","b")));
    }
}
