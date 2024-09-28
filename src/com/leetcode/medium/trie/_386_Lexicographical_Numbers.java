package com.leetcode.medium.trie;

import java.util.ArrayList;
import java.util.List;

public class _386_Lexicographical_Numbers {
    //386. Lexicographical Numbers
    //https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2024-09-21

    public List<Integer> lexicalOrder(int n) {
        TrieRoot t = new TrieRoot();
        for (int i = 1; i <= n; i++) {
            t.add(Integer.valueOf(i).toString(), 0, t.root);
        }
        List<Integer> l = new ArrayList<>();

        t.dfs("", t.root, l);
        return l;
    }

    private static class Trie {
        int c;
        Trie[] ar = new Trie[26];

        public Trie(int ch) {
            c = ch;
        }
        public Trie() {

        }
    }

    private static class TrieRoot {
        Trie root;

        public TrieRoot() {
            root = new Trie();
        }

        public void add(String s, int i, Trie t) {
            if (i == s.length()) return;
            char ch = s.charAt(i);
            if (t.ar[ch - '0'] == null) {
                var tr = new Trie(ch - '0');
                t.ar[ch - '0'] = tr;
                add(s, i + 1, tr);
            } else {
                add(s, i + 1, t.ar[ch - '0']);
            }
        }

        public void dfs(String s, Trie t, List<Integer> list) {
            if (s != "") {
                list.add(Integer.valueOf(s));
            }
            for (var tr: t.ar) {
                if (tr != null) dfs(s + tr.c, tr, list);
            }
        }
    }
}
