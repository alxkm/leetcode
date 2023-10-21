package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110_Delete_Nodes_And_Return_Forest {
    //https://leetcode.com/problems/delete-nodes-and-return-forest/
    //1110. Delete Nodes And Return Forest
    //FOREIGN_SOLUTION
    //TOP

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> l = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n: to_delete) set.add(n);
        if (!set.contains(root.val)) l.add(root);
        else {
            if (root.left != null && !set.contains(root.left.val)) l.add(root.left);
            if (root.right != null && !set.contains(root.right.val)) l.add(root.right);
        }
        dfs(l, set, root.left, root, true);
        dfs(l, set, root.right, root, false);
        return l;
    }

    private void dfs(List<TreeNode> l, Set<Integer> set, TreeNode t, TreeNode prev, boolean left) {
        if (t == null) return;

        dfs(l, set, t.left, t, true);
        dfs(l, set, t.right, t, false);

        if (set.contains(t.val)) {
            set.remove(t.val);
            if (left) {
                prev.left = null;
            } else {
                prev.right = null;
            }
            if (t.left != null) l.add(t.left);
            if (t.right != null) l.add(t.right);
        }
    }
}
