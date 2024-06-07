package com.leetcode.medium.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _648_Replace_Words {
    //648. Replace Words
    //https://leetcode.com/problems/replace-words/description/

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        int min = dictionary.get(0).length();
        int max = dictionary.get(0).length();
        Set<String> set = new HashSet<>(dictionary);
        for (String str : dictionary) {
            //t.add(str);
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }

        StringBuilder sb = new StringBuilder();
        String[] ar = sentence.split(" ");
        for (String s : ar) {
            String candidate = s;
            for (int i = min; i <= Math.min(max, s.length()); i++) {
                String str = s.substring(0, i);
                //if (t.search(str)) {
                if (set.contains(str)) {
                    candidate = str;
                    break;
                }
            }
            sb.append(candidate).append(" ");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }


    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isTerminated;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        void add(String s) {
            var p = root;
            for (char ch : s.toCharArray()) {
                if (!p.children.containsKey(ch)) {
                    p.children.put(ch, new TrieNode());
                }
                p = p.children.get(ch);
            }
            p.isTerminated = true;
        }

        boolean search(String s) {
            var p = root;
            for (char ch : s.toCharArray()) {
                if (!p.children.containsKey(ch)) {
                    return false;
                }
                p = p.children.get(ch);
            }
            return p.isTerminated;
        }

        boolean startWith(String s) {
            var p = root;
            for (char ch : s.toCharArray()) {
                if (!p.children.containsKey(ch)) {
                    return false;
                }
                p = p.children.get(ch);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        var sol = new _648_Replace_Words();
        System.out.println(sol.replaceWords(List.of("cattl", "bat", "rat", "cat"), "the cattle was rattled by the battery"));
    }
}
