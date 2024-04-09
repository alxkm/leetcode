package com.leetcode.top.top175;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    //103. Binary Tree Zigzag Level Order Traversal
    //todo todo
    //tree

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);
        boolean start = true;
        while (!stack1.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            Stack<TreeNode> stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                var e = stack1.pop();
                l.add(e.val);
                if (start) {
                    if (e.left != null) {
                        stack2.add(e.left);
                    }
                    if (e.right != null) {
                        stack2.add(e.right);
                    }
                } else {
                    if (e.right != null) {
                        stack2.add(e.right);
                    }
                    if (e.left != null) {
                        stack2.add(e.left);
                    }
                }
            }
            if (l.size() > 0) ll.add(l);
            start = (start) ? false : true;
            if (!stack2.isEmpty()) stack1 = stack2;
        }
        return ll;
    }
}
