package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
    //889. Construct Binary Tree from Preorder and Postorder Traversal
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/

    class Solution {
        int[] preorder;
        int[] postorder;
        int i = 0;
        int j = 0;

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            this.preorder = preorder;
            this.postorder = postorder;
            return f();
        }

        private TreeNode f() {
            if (i >= preorder.length || j >= preorder.length) {
                return null;
            }
            TreeNode t = new TreeNode(preorder[i++]);
            if (t.val != postorder[j]) {
                t.left = f();
            }
            if (t.val != postorder[j]) {
                t.right = f();
            }
            j++;
            return t;
        }
    }
}
