package com.leetcode.top.tree;

import java.util.ArrayList;
import java.util.List;

public class _590_N_ary_Tree_Postorder_Traversal {
    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/
    //590. N-ary Tree Postorder Traversal

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    private void dfs(Node root, List<Integer> l) {
        if (root == null) return;

        for (Node n : root.children) {
            dfs(n, l);
        }

        l.add(root.val);
    }


    public List<Integer> preorder1(Node root) {
        List<Integer> l = new ArrayList<>();
        dfs1(root, l);
        return l;
    }

    private void dfs1(Node root, List<Integer> l) {
        if (root == null) return;
        l.add(root.val);
        for (Node n : root.children) dfs1(n, l);
    }

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> l = new ArrayList<>();
            dfs(root, l);
            return l;
        }

        private void dfs(Node t, List<Integer> l) {
            if (t == null) return;

            for (var n: t.children) {
                dfs(n, l);
            }
            l.add(t.val);
        }
    }
}
