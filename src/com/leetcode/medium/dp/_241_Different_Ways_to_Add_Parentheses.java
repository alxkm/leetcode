package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
