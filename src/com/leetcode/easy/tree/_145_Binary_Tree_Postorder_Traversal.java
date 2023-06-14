package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
