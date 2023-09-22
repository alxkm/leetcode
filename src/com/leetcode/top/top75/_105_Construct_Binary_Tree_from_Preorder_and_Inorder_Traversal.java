package com.leetcode.top.top75;

import com.leetcode.TreeNode;

import java.util.Arrays;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    //FOREIGN_SOLUTION
    //TOP

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;
        int mid = -1;
        for(int i = 0; i < inorder.length; i++) { if (inorder[i] == preorder[0]) { mid = i; break;} }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }
}
