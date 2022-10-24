package com.company.tree;

public class _1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {


    TreeNode dfs(TreeNode t, TreeNode s) {
        if (t != null) {
            if (t.val == s.val) return t;
            var tn = dfs(t.left, s);
            if (tn == null) {
                tn = dfs(t.right, s);
            }
            return tn;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
