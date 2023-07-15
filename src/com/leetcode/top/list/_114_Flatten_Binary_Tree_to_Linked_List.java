package com.leetcode.top.list;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _114_Flatten_Binary_Tree_to_Linked_List {
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        List<TreeNode> l = new ArrayList<>();
        st.add(root);
        while (!st.isEmpty()) {
            var t = st.pop();
            l.add(t);
            if (t.right != null) st.add(t.right);
            if (t.left != null) st.add(t.left);
        }
        for (int i = 1; i < l.size(); i++) {
            root.right = l.get(i);
            root.left = null;
            root = root.right;
        }
    }
}
