package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _2416_Sum_of_Prefix_Scores_of_Strings {
    //2416. Sum of Prefix Scores of Strings
    //https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/?envType=daily-question&envId=2024-09-25
    //NOT_MAIN
    //TRIE
    //TODO

    class Solution {
        public int[] sumPrefixScores(String[] words) {
            final int m = 10007;
            Map<Long, Integer> map = new HashMap<>();
            for (String s: words) {
                long rolingHash = 0L;
                for (var ch: s.toCharArray()) {
                    rolingHash = rolingHash * m + ch;
                    map.put(rolingHash, map.getOrDefault(rolingHash, 0) + 1);
                }
            }
            int[] prefixScores = new int[words.length];
            for (int i = 0; i < prefixScores.length; i++) {
                var s = words[i];
                int score = 0;
                long rolingHash = 0L;
                for (char ch: s.toCharArray()) {
                    rolingHash = rolingHash * m + ch;
                    Integer curScore = map.get(rolingHash);
                    if (curScore == null) break;
                    score += curScore;
                }
                prefixScores[i] = score;
            }
            return prefixScores;
        }
    }

    //TL
    class Solution1 {
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
                        if (l.get(j).contains(s)) counter++;
                    }
                }
                counters[i] = counter;
            }
            return counters;
        }
    }

    //TL
    class Solution2 {
        public int[] sumPrefixScores(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            List<List<String>> l = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                l.add(new ArrayList<>());
                for (int j = 1; j <= s.length(); j++) {
                    var str = s.substring(0, j);
                    l.get(i).add(str);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            int[] prefixScores = new int[words.length];
            for (int i = 0; i < prefixScores.length; i++) {
                var s = words[i];
                int score = 0;
                for (int j = 0; j < s.length(); j++) {
                    var str = l.get(i).get(j);
                    Integer curScore = map.get(str);
                    if (curScore == null) break;
                    score += curScore;
                }
                prefixScores[i] = score;
            }
            return prefixScores;
        }
    }

    //TL
    class Solution3 {
        public int[] sumPrefixScores(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            for (String s: words) {
                StringBuilder sb = new StringBuilder();
                for (var ch: s.toCharArray()) {
                    sb.append(ch);
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }
            }
            int[] prefixScores = new int[words.length];
            for (int i = 0; i < prefixScores.length; i++) {
                var s = words[i];
                int score = 0;
                StringBuilder sb = new StringBuilder();
                for (char ch: s.toCharArray()) {
                    sb.append(ch);
                    Integer curScore = map.get(sb.toString());
                    if (curScore == null) break;
                    score += curScore;
                }
                prefixScores[i] = score;
            }
            return prefixScores;
        }
    }
}
