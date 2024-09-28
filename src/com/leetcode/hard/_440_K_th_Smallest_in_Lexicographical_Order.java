package com.leetcode.hard;

import java.util.Objects;
import java.util.Stack;

public class _440_K_th_Smallest_in_Lexicographical_Order {
    //440. K-th Smallest in Lexicographical Order
    //https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
    //TRIE

    static int k = 0;

    public int findKthNumber(int n, int k) {
        this.k = k;
        TrieRoot t = new TrieRoot();
        for (int i = 1; i <= n; i++) {
            t.add(t.root, Integer.valueOf(i).toString(), 0);
        }
        Stack<Character> st = new Stack<>();
        t.dfsStacked(t.root, st, true);
        StringBuilder sb = new StringBuilder();
        for (Character character : st) {
            sb.append(character);
        }
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    public static class Trie {
        Trie[] array = new Trie[10];
        char ch;
        public Trie(char ch) {
            this.ch = ch;
        }
        public Trie() {}
    }

    public static class TrieRoot {
        Trie root;

        public TrieRoot() {
            root = new Trie();
        }

        public void add(Trie t, String n, int i) {
            if (i >= n.length()) return;
            char ch = n.charAt(i);
            int index = ch - '0';
            var arr = t.array;
            if (arr[index] == null) {
                arr[index] = new Trie(ch);
                add(arr[index], n, i + 1);
            } else {
                add(arr[index], n, i + 1);
            }
        }

        public String dfs(Trie t, String s, boolean init) {
            if (k == 0) return s;
            if (t == null) return "";
            k--;
            for (int i = (init) ? 1 : 0; i < t.array.length; i++) {
                if (t.array[i] == null) return "";
                String newStr = s + t.array[i].ch;
                var resultStr = dfs(t.array[i], newStr, false);
                if (!Objects.equals(resultStr, "")) return resultStr;
            }
            return "";
        }

        public boolean dfsStacked(Trie t, Stack<Character> st, boolean init) {
            if (k == 0) return true;
            if (t == null) return false;
            k--;
            st.push(t.ch);
            for (int i = (init) ? 1 : 0; i < t.array.length; i++) {
                if (t.array[i] == null) return false;
                if (dfsStacked(t.array[i], st, false)) return true;
            }
            st.pop();
            return false;
        }
    }

    public static void main(String[] args) {
        var sol = new _440_K_th_Smallest_in_Lexicographical_Order();
        sol.findKthNumber(1, 1);
    }
}
