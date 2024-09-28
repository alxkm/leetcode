package com.leetcode.medium.trie;

import com.leetcode.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

public class _3043_Find_the_Length_of_the_Longest_Common_Prefix {
    //https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
    //3043. Find the Length of the Longest Common Prefix
    //TRIE

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int n: arr2) {
            String s = Integer.valueOf(n).toString();
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }
        int max = 0;
        for (int n: arr1) {
            String s = Integer.valueOf(n).toString();
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (set.contains(sub)) {
                    max = Math.max(sub.length(), max);
                }
            }
        }

        return max;
    }
















    public int longestCommonPrefix1(int[] arr1, int[] arr2) {
        int max = 0;
        TrieBuilder tb = new TrieBuilder();

        for (int i = 0; i < arr1.length; i++) {
            tb.add(tb.root, arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            max = Math.max(max, tb.dfs(tb.root, arr2[i]));
        }

        return max;
    }

    public static class Trie {
        Trie[] ar;
        int v;

        public Trie() {
            ar = new Trie[10];
        }
        public Trie(int v) {
            ar = new Trie[10];
            this.v = v;
        }
    }

    public static class TrieBuilder {
        Trie root;

        public TrieBuilder() {
            root = new Trie();
        }

        public void add(Trie t, int v) {
            if (v == 0) return;
            int n = v % 10;
            v /= 10;
            if (t.ar[n] == null) {
                t.ar[n] = new Trie();
                add(t.ar[n], v);
            } else {
                add(t.ar[n], v);
            }
        }

        public int dfs(Trie t, int v) {
            int n = v % 10;
            Trie trie = t.ar[n];
            if (trie == null) return 0;
            v /= 10;
            return 1 + dfs(trie, v);
        }
    }

    public static void main(String[] args) {
        var sol = new _3043_Find_the_Length_of_the_Longest_Common_Prefix();
        System.out.println(sol.longestCommonPrefix(ArrayUtil.of(1, 10, 100), ArrayUtil.of(1000)));
    }
}
