package com.leetcode.backtrack_dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _131_Palindrome_Partitioning {
    //https://leetcode.com/problems/palindrome-partitioning/
    //131. Palindrome Partitioning
    //todo todo

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        f(0, s, new Stack<>(), result);
        return result;
    }

    private void f(int i, String s, Stack<String> cur, List<List<String>> result) {
        if (i == s.length()) {
            result.add(cur);
        }

        for (int j = i; j < s.length(); j++) {
            if (isPal(i, j, s)) {
                cur.add(s.substring(i, j + 1));
                f(j + 1, s, cur, result);
                cur.pop();
            }
        }
    }

    private boolean isPal(int l, int r, String s) {
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _131_Palindrome_Partitioning solution = new _131_Palindrome_Partitioning();
        solution.partition("aab");
    }
}
