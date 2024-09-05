package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _726_Number_of_Atoms {
    //726. Number of Atoms
    //https://leetcode.com/problems/number-of-atoms/description/

    private char[] s;

    public String countOfAtoms(String formula) {
        s = formula.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; ) {
            if (s[i] == '(') {
                i++;
                HashMap<String, Integer> newMap = new HashMap<>();
                i = f(i, newMap);

                if (i < s.length && s[i] == ')') {
                    if (i < s.length) i++;
                    if (i < s.length && Character.isDigit(s[i])) {
                        StringBuilder number = new StringBuilder();
                        if (i < s.length && Character.isDigit(s[i])) {
                            while (i < s.length && Character.isDigit(s[i])) {
                                number.append(s[i]);
                                i++;
                            }
                        }
                        int newNumber = number.isEmpty() ? 1 : Integer.parseInt(number.toString());
                        for (var entry: map.entrySet()) {
                            map.put(entry.getKey(), newNumber * entry.getValue());
                        }
                    }
                }

                mergeTwoMaps(map, newMap);
            } else if (Character.isAlphabetic(s[i])) {
                i = parseElementAndValue(i, map);
            }
        }
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for (var key: sortedMap.keySet()) {
            sb.append(key);
            int value = map.get(key);
            if (value > 1) sb.append(map.get(key));
        }
        return sb.toString();
    }

    private static void mergeTwoMaps(Map<String, Integer> map, Map<String, Integer> newMap) {
        for (var key : newMap.keySet()) {
            map.merge(key, newMap.get(key), Integer::sum);
        }
    }

    private int parseElementAndValue(int i, Map<String, Integer> map) {
        StringBuilder element = new StringBuilder().append(s[i]);
        i++;
        if (i < s.length && Character.isAlphabetic(s[i]) && Character.isLowerCase(s[i])) {
            element.append(s[i]);
            i++;
        }
        StringBuilder number = new StringBuilder();
        if (i < s.length && Character.isDigit(s[i])) {
            while (i < s.length && Character.isDigit(s[i])) {
                number.append(s[i]);
                i++;
            }
        }
        int newNumber = number.isEmpty() ? 1 : Integer.parseInt(number.toString());
        map.merge(element.toString(), newNumber, Integer::sum);
        return i;
    }

    private int f(int i, Map<String, Integer> map) {
        while (i < s.length && s[i] != ')') {
            if (s[i] == '(') {
                HashMap<String, Integer> newMap = new HashMap<>();
                i = f(i + 1, newMap);
                mergeTwoMaps(map, newMap);
            }
            if (i < s.length && Character.isAlphabetic(s[i])) {
                i = parseElementAndValue(i, map);
            }
        }
        if (i < s.length) i++;
        if (i < s.length && Character.isDigit(s[i])) {
            StringBuilder number = new StringBuilder();
            if (i < s.length && Character.isDigit(s[i])) {
                while (i < s.length && Character.isDigit(s[i])) {
                    number.append(s[i]);
                    i++;
                }
            }
            int newNumber = number.isEmpty() ? 1 : Integer.parseInt(number.toString());
            for (var entry: map.entrySet()) {
                map.put(entry.getKey(), newNumber * entry.getValue());
            }
        }
        return i;
    }
}
