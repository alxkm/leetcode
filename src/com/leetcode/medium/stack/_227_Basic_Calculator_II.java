package com.leetcode.medium.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;

public class _227_Basic_Calculator_II {
    //https://leetcode.com/problems/basic-calculator-ii/

    private Map<String, BiFunction<String, String, Integer>> ops = new HashMap<>();
    private Set<Character> secondPriorityOps = Set.of('-', '+');

    {
        ops.put("+", (a, b) -> Integer.parseInt(a) + Integer.parseInt(b));
        ops.put("-", (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        ops.put("*", (a, b) -> Integer.parseInt(a) * Integer.parseInt(b));
        ops.put("/", (a, b) -> Integer.parseInt(a) / Integer.parseInt(b));
    }

    public int calculate(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                while (i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    sb.append(s.charAt(i));
                }

                st.add(sb.toString());
                continue;
            }

            if (secondPriorityOps.contains(ch)) {
                st.add(String.valueOf(ch));
                continue;
            }

            StringBuilder second = new StringBuilder();
            while ((i + 1 <= s.length() - 1 && Character.isDigit(s.charAt(i + 1)))
                    || (i + 1 <= s.length() - 1 && s.charAt(i + 1) == ' ')
            ) {

                if (s.charAt(i + 1) == ' ') {
                    i++;
                    continue;
                }
                i++;
                second.append(s.charAt(i));
            }

            String first = st.pop();
            String result = ops.get(String.valueOf(ch)).apply(first, second.toString()).toString();
            st.add(result);
        }
        Deque<String> deque = new LinkedList<>(st);
        if (deque.size() > 1) {
            while (deque.size() > 1) {
                String a = deque.poll();
                String op = deque.poll();
                String b = deque.poll();
                String result = ops.get(op).apply(a, b).toString();
                deque.addFirst(result);
            }
        }
        return Integer.parseInt(deque.poll());
    }

    public static void main(String[] args) {
        var solution = new _227_Basic_Calculator_II();
        //String str = "3+2*2";
        //String str = " 3/2 ";
        //String str = " 3+5 / 2 ";
        String str = "0-2147483647";
        //String str = "1-1+1";
        solution.calculate(str);
    }
}
