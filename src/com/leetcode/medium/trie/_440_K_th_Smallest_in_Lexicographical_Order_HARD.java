package com.leetcode.medium.trie;

import java.util.Objects;
import java.util.Stack;

public class _440_K_th_Smallest_in_Lexicographical_Order_HARD {
    //440. K-th Smallest in Lexicographical Order
    //https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
    //TRIE
    //HARD
   public static class Solution {

        public int findKthNumber(int n, int k) {
            int curr = 1;
            k--;

            while (k > 0) {
                int step = countSteps(n, curr, curr + 1);
                // If the steps are less than or equal to k, we skip this prefix's subtree
                if (step <= k) {
                    // Move to the next prefix and decrease k by the number of steps we skip
                    curr++;
                    k -= step;
                } else {
                    // Move to the next level of the tree and decrement k by 1
                    curr *= 10;
                    k--;
                }
            }

            return curr;
        }

        // To count how many numbers exist between prefix1 and prefix2
        private int countSteps(int n, long prefix1, long prefix2) {
            int steps = 0;
            while (prefix1 <= n) {
                steps += Math.min(n + 1, prefix2) - prefix1;
                prefix1 *= 10;
                prefix2 *= 10;
            }
            return steps;
        }
    }

    class Solution1 {
        static int k = 0;

        public int findKthNumber(int n, int k) {
            if (n == 1 && k == 1) return 1;
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
                root.ch = '*';
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
                if (t == null) return "";
                if (k == 0) return s;
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
                if (t.ch != '*') st.push(t.ch);
                for (int i = (init) ? 1 : 0; i < t.array.length; i++) {
                    if (t.array[i] == null) return false;
                    if (dfsStacked(t.array[i], st, false)) return true;
                }
                st.pop();
                return false;
            }
        }
    }
}
