package com.leetcode.medium.queue;

import com.leetcode.Pair;

import java.util.PriorityQueue;

public class _2182_Construct_String_With_Repeat_Limit {
    //2182. Construct String With Repeat Limit
    //https://leetcode.com/problems/construct-string-with-repeat-limit/description/

    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] l = new int[26];
            for (char ch: s.toCharArray()) {
                l[ch - 'a']++;
            }

            PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());
            for (int i = 0; i < l.length; i++) {
                if (l[i] > 0) {
                    pq.offer(new Pair<>((char)(i + 'a'), l[i]));
                }
            }
            StringBuilder sb = new StringBuilder();
            char prev = ' ';
            while (!pq.isEmpty()) {
                Pair<Character, Integer> p1 = pq.poll();
                if (pq.size() == 0) {
                    for (int i = 0; i < p1.getValue() && i < repeatLimit && prev != p1.getKey(); i++) {
                        sb.append(p1.getKey());
                    }
                    break;
                }
                Pair<Character, Integer> p2 = pq.poll();
                int size1 = p1.getValue();
                int size2 = p2.getValue();

                if (prev != p1.getKey()) {
                    for (int i = 0; i < p1.getValue() && i < repeatLimit && prev != p1.getKey(); i++) {
                        sb.append(p1.getKey());
                        size1--;
                    }
                }
                prev = p1.getKey();
                for (int i = 0; i < p2.getValue() && prev != p2.getKey() && (i < (size1 == 0 ? repeatLimit : 1)); i++) {
                    sb.append(p2.getKey());
                    size2--;
                }
                prev = p2.getKey();
                if (size1 > 0) pq.offer(new Pair<>(p1.getKey(), size1));
                if (size2 > 0) pq.offer(new Pair<>(p2.getKey(), size2));
            }
            return sb.toString();
        }
    }
}
