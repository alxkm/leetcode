package com.leetcode.top.top175;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _767_Reorganize_String {
    //https://leetcode.com/problems/reorganize-string/
    //FOREIGN_SOLUTION
    //TOP

    public String reorganizeString(String s) {
        Map<Character, Integer> fr = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : s.toCharArray()) {
            fr.put(ch, fr.getOrDefault(ch, 0) + 1);
        }
        //min heap a - b
        //max heap b - a
        Queue<Character> q = new PriorityQueue<>((a, b) -> fr.get(b) - fr.get(a));

        for (char ch: fr.keySet()) {
            q.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        int size = 0;
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            size = fr.getOrDefault(ch, 0) - 1;
            fr.put(ch, fr.getOrDefault(ch, 0) - 1);

            if (size > 0) {
                q.offer(ch);
            }
        }

        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == sb.charAt(i)) return "";
        }

        return sb.toString();
    }

    /*
    public String reorganizeString(String s) {
        Map<Character, Integer> fr = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while(map.size() > 0) {
            char ch1 = getMax(map);
            int max1 = map.get(ch1);
            map.remove(ch1);
            if (map.size() > 0) {
                char ch2 = getMax(map);
                Integer max2 = map.get(ch1);
                if (max2 != null) {

                    map.remove(ch2);
                    int i = 0;
                    int j = 0;
                    while (i < max1 || j < max2) {
                        sb.append(ch1);
                        i++;
                        sb.append(ch2);
                        j++;
                    }
                    if (j < max2) {
                        map.put(ch2, j);
                    }
                } else {
                    if (max1 > 1) return "";
                    sb.append(ch1);
                }
            } else if (max1 > 1) {
                return "";
            }
        }
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == sb.charAt(i)) return "";
        }

        return sb.toString();
    }

    private char getMax(Map<Character, Integer> map) {
        int max = 0;
        char index = ' ';
        for (var entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        return index;
    }
    *
    * */

    public static void main(String[] args) {
        _767_Reorganize_String solution = new _767_Reorganize_String();
        String s = "aabbc";
        System.out.println(solution.reorganizeString(s));
    }
}
