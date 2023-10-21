package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.LinkedList;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    //236. Lowest Common Ancestor of a Binary Tree
    //top
    //not_optimal
    //todo todo todo

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) return p;
        if (root == p || root == q) return root;
        var leftSt = new LinkedList<TreeNode>();
        var rightSt = new LinkedList<TreeNode>();
        dfs(root, leftSt, p);
        dfs(root, rightSt, q);

        if (leftSt.size() > rightSt.size()) {
            while (leftSt.size() != rightSt.size()) leftSt.pop();
        } else if (leftSt.size() < rightSt.size()) {
            while (leftSt.size() != rightSt.size()) rightSt.pop();
        }

        while (!leftSt.isEmpty() && !rightSt.isEmpty()) {
            var pt = leftSt.pop();
            var qt = rightSt.pop();
            if (pt == qt) return pt;
        }

        return root;
    }

    private void dfs(TreeNode t, LinkedList<TreeNode> st, TreeNode p) {
        if (t == null) {
            return;
        }
        if (t == p) {
            st.add(t);
            return;
        }
        dfs(t.left, st, p);
        if (!st.isEmpty()) {
            st.add(t);
        } else {
            dfs(t.right, st, p);
            if (!st.isEmpty()) {
                st.add(t);
            }
        }
    }
}
