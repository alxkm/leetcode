package com.leetcode.medium.tree;

import com.leetcode.top.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Definition for a Node.
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
*/

public class _429_N_ary_Tree_Level_Order_Traversal {
    //429. N-ary Tree Level Order Traversal
    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/

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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ll = new ArrayList<>();
        if (root == null) return ll;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = 1;

        while (!q.isEmpty()) {
            int tempSize = size;
            size = 0;
            List<Integer> l = new ArrayList<>();
            while (tempSize > 0) {
                var node = q.poll();
                if (node != null) {
                    l.add(node.val);
                    if (node.children != null || !node.children.isEmpty()) {
                        for (var n: node.children) {
                            q.offer(n);
                            size++;
                        }
                    }
                    tempSize--;
                }

            }
            if (!l.isEmpty()) ll.add(l);
        }

        return ll;
    }
}
