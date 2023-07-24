package com.leetcode.top.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _211_Design_Add_and_Search_Words_Data_Structure {
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/

    class WordDictionary {
        public class Trie {
            public char ch;
            public Map<Character, Trie> map;
            public boolean end;

            public Trie(char ch) {
                this.ch = ch;
                this.map = new HashMap<>();
            }

            public Trie() {
                map = new HashMap<>();
            }
        }

        public Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            var t = root;
            for (char ch: word.toCharArray()) {
                var newt = t.map.get(ch);
                if (newt == null) {
                    newt = new Trie();
                    t.map.put(ch, newt);
                }
                t = newt;
            }
            t.end = true;
        }

        public boolean search(String word) {
            List<Boolean> result = new ArrayList<>();
            dfs(0, word.toCharArray(), root, result);
            for (var r: result) if (r) return true;
            return false;
        }

        public void dfs(int i, char[] w, Trie t, List<Boolean> l) {
            var cur = t.map.get(w[i]);
            if (w.length - 1 == i) {
                if (w[i] == '.') {
                    for (var v: t.map.values()) {
                        if (v.end) {
                            l.add(true);
                            return;
                        }
                    }
                    l.add(false);
                    return;
                }
                if (cur != null && cur.end) {
                    l.add(true);
                    return;
                }
                l.add(false);
                return;
            }

            if (w[i] == '.') {
                for (var v: t.map.values()) {
                    dfs(i + 1, w, v, l);
                }
            }
            if (cur == null) {
                l.add(false);
                return;
            }
            dfs(i + 1, w, cur, l);
        }
    }
}
