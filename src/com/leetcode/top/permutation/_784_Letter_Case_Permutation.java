package com.leetcode.top.permutation;

import java.util.ArrayList;
import java.util.List;

public class _784_Letter_Case_Permutation {
    //https://leetcode.com/problems/letter-case-permutation/
    //784. Letter Case Permutation
    //backtrack

    private void f(int v, char[] s, char[] news, List<String> l) {
        if (v == s.length) {
            l.add(String.valueOf(news));
            return;
        }

        if (Character.isAlphabetic(s[v])) {
            news[v] = Character.toLowerCase(s[v]);
            f(v + 1, s, news, l);
            news[v] = Character.toUpperCase(s[v]);
            f(v + 1, s, news, l);
        } else {
            news[v] = s[v];
            f(v + 1, s, news, l);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> l = new ArrayList<>();
        char[] news = new char[s.length()];
        f(0, s.toCharArray(), news, l);
        return l;
    }
}
