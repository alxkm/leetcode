package com.leetcode.easy.tree;

import java.util.List;

public class _559_Maximum_Depth_of_N_ary_Tree {
    //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;

        for (Node n : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(n));
        }

        return maxDepth + 1;
    }

    public void dfs(Node n, int c, List<Integer> l) {
        if (n.children == null || n.children.size() == 0) {
            l.add(c);
            return;
        }
        for (Node nn : n.children) {
            dfs(nn, c + 1, l);
        }
    }
}
