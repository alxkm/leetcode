package com.company.tree;

public class _700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }

    TreeNode search(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) return root;

            TreeNode t = search(root.left, val);

            if (t == null) t = search(root.right, val);

            return t;
        }
        return null;
    }
}
