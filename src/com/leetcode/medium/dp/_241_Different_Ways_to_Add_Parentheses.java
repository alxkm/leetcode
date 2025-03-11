package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _241_Different_Ways_to_Add_Parentheses {
    //241. Different Ways to Add Parentheses
    //https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=daily-question&envId=2024-09-19
    // DP
    // NOT MAIN
    //TODO

    Map<String, List<Integer>> dp = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return f(expression);
    }

    private List<Integer> f(String s) {
        if (dp.containsKey(s)) return dp.get(s);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                String lp = s.substring(0, i);
                String rp = s.substring(i + 1, s.length());

                List<Integer> leftResults = f(lp);
                List<Integer> rightResults = f(rp);

                for (int left: leftResults) {
                    for (int right: rightResults) {
                        if (c == '+') {
                            list.add(left + right);
                        } else if (c == '-') {
                            list.add(left - right);
                        } else if (c == '*') {
                            list.add(left * right);
                        }
                    }
                }
            }
        }

        if (list.isEmpty()) {
            list.add(Integer.parseInt(s));
        }

        dp.put(s, list);
        return list;
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int k = nums.size();
        for (var l: nums) {
            for (int n: l) {
                map.computeIfAbsent(n, key -> new ArrayList<>()).add(n);
            }
        }
        List<Integer> allk = new ArrayList<>();

        for (var key: map.keySet()) {
            if (map.get(key).size() == k) allk.add(key);
        }

        int[] min = new int[2];
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < allk.size() - 1; i++) {
            if (distance > allk.get(i) - allk.get(i + 1)) {
                min[0] = allk.get(i);
                min[1] = allk.get(i + 1);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        smallestRange(List.of(List.of(4,10,15,24,26), List.of(0,9,12,20), List.of(5,18,22,30)));
    }
}
