package com.leetcode.medium.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class _150_Evaluate_Reverse_Polish_Notation {
    //https://leetcode.com/problems/evaluate-reverse-polish-notation/

    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (x, y) -> x + y);
        map.put("-", (x, y) -> x - y);
        map.put("*", (x, y) -> x * y);
        map.put("/", (x, y) -> x / y);

        Stack<Integer> stack = new Stack<>();

        for (String str: tokens) {
            if (map.containsKey(str)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.add(map.get(str).apply(y, x));
            } else {
                stack.add(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    static class Solution1 {
        private int position;
        private String[] tokens;

        public int evalRPN(String[] tokens) {
            this.tokens = tokens;
            this.position = tokens.length - 1;
            return eval();
        }

        private int eval() {
            String str = tokens[position--];
            switch (str) {
                case "+":
                    return eval() + eval();
                case "-":
                    return - eval() + eval();
                case "*":
                    return eval() * eval();
                case "/":
                    int x = eval();
                    int y = eval();
                    return y / x;
                default :
                    return Integer.parseInt(str);
            }
        }
    }
}
