package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1315_Sum_of_Nodes_with_Even_Valued_Grandparent {
    //1315. Sum of Nodes with Even-Valued Grandparent
    //https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, -1, -1);
    }

    private int dfs(TreeNode t, int pv, int gv) {
        if (t == null) return 0;

        return dfs(t.right, t.val, pv) + dfs(t.left, t.val, pv) + (gv % 2 == 0 ? t.val : 0);
    }
}
