package com.leetcode.top.trie;

import java.util.HashMap;
import java.util.Map;

public class _208_Implement_Trie_Prefix_Tree {
    //https://leetcode.com/problems/implement-trie-prefix-tree/
    //FOREIGN_SOLUTION
    //TOP

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isTerminated;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            var p = this.root;
            for (var c : word.toCharArray()) {
                if (p.children.get(c) == null) {
                    p.children.put(c, new TrieNode());
                }
                p = p.children.get(c);
            }
            p.isTerminated = true;
        }

        public boolean search(String word) {
            var p = this.root;
            for (var c : word.toCharArray()) {
                p = p.children.get(c);
                if (p == null) {
                    return false;
                }
            }
            return p.isTerminated;
        }

        public boolean startsWith(String prefix) {
            var p = this.root;
            for (var c : prefix.toCharArray()) {
                p = p.children.get(c);
                if (p == null) {
                    return false;
                }
            }
            return true;
        }
    }

}
