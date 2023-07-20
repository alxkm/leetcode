package com.leetcode.medium.math;

import java.util.List;

public class _12_Integer_to_Roman {
    //https://leetcode.com/problems/integer-to-roman/description/

    public class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public String intToRoman(int num) {
        List<Pair> list = List.of(
                new Pair("I", 1), new Pair("IV", 4), new Pair("V", 5),
                new Pair("IX", 9), new Pair("X", 10), new Pair("XL", 40), new Pair("L", 50),
                new Pair("XC", 90), new Pair("C", 100), new Pair("CD", 400), new Pair("D", 500),
                new Pair("CM", 900), new Pair("M", 1000)
        );
        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            String key = list.get(i).key;
            int val = list.get(i).value;
            int count = num / val;
            if (count > 0) {
                sb.append(key.repeat(count));
                num %= val;
            }
        }

        return sb.toString();
    }
}
