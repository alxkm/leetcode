package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1807_Evaluate_the_Bracket_Pairs_of_a_String {
    //1807. Evaluate the Bracket Pairs of a String
    //https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                i++;
                int j = i;
                while (s.charAt(j) != ')') j++;
                sb.append(map.getOrDefault(s.substring(i, j), "?"));
                i = j;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
