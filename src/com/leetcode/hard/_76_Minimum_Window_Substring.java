package com.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _76_Minimum_Window_Substring {
    //https://leetcode.com/problems/minimum-window-substring/
    //hard
    //hashmap

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.contains(t)) return t;
        Map<Character, Integer> referenceFrequencyMap = new HashMap<>();
        Map<Character, Integer> curFrequencyMap = new HashMap<>();
        for (char ch: t.toCharArray()) {
            referenceFrequencyMap.put(ch, referenceFrequencyMap.getOrDefault(ch, 0) + 1);
            curFrequencyMap.put(ch, 0);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (curFrequencyMap.containsKey(s.charAt(i))) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) return "";

        String min = "";
        int left = queue.poll();
        int right = left + 1;
        int size = 1;
        curFrequencyMap.put(s.charAt(left), 1);

        while (left < s.length() - (t.length() - 1)) {

            while (right < s.length()) {
                char ch = s.charAt(right);
                if (curFrequencyMap.containsKey(ch)) {
                    curFrequencyMap.put(ch, curFrequencyMap.get(ch) + 1);
                    if (curFrequencyMap.get(ch) <= referenceFrequencyMap.get(ch)) {
                        size++;
                    }
                }
                right++;
                if (size == t.length()) {
                    break;
                }
            }

            while (size == t.length()) {
                String str = s.substring(left, right);
                if (str.length() < min.length() || min.equals("")) {
                    min = str;
                }
                char prevCh = s.charAt(left);
                curFrequencyMap.put(prevCh, curFrequencyMap.get(prevCh) - 1);
                size--;
                if (curFrequencyMap.get(prevCh) >= referenceFrequencyMap.get(prevCh)) {
                    size++;
                }
                if (queue.isEmpty()) return min;
                left = queue.poll();
            }
            if (right >= s.length()) break;
        }
        return min;
    }

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "ab", t = "a";
        var sol = new _76_Minimum_Window_Substring();
        System.out.println(sol.minWindow(s, t));
    }
}
