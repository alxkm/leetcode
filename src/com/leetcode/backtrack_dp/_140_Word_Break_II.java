package com.leetcode.backtrack_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _140_Word_Break_II {
    //https://leetcode.com/problems/word-break-ii/
    //140. Word Break II

    List<String> result = new ArrayList<>();
    String s;
    Set<String> set = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        this.s = s;
        f(0, new Stack<>());
        return result;
    }

    private void f(int i, Stack<String> stack) {
        if (i == s.length()) {
            int totalLength = 0;
            for (String string : stack) {
                totalLength += string.length();
            }
            if (totalLength == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < stack.size(); j++) {
                    sb.append(stack.get(j));
                    if (j != stack.size() - 1) {
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
            }
        }

        for (int j = i; j < s.length(); j++) {
            for (int k = j + 1; k <= s.length(); k++) {
                String word = s.substring(j, k);
                if (set.contains(word)) {
                    stack.add(word);
                    f (k, stack);
                    stack.pop();
                }

            }
        }
    }

    public static void main(String[] args) {
        var sol = new _140_Word_Break_II();
        System.out.println(sol.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }

}
