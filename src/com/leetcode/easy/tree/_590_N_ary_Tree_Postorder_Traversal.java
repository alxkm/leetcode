package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class _590_N_ary_Tree_Postorder_Traversal {
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
    }

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
}
