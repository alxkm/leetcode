package com.leetcode.top.top175;


import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _199_Binary_Tree_Right_Side_View {
    //199. Binary Tree Right Side View
    //https://leetcode.com/problems/binary-tree-right-side-view/
    //todo todo todo

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, 0, l);
        return l;
    }

    private void dfs(TreeNode t, int level, List<Integer> l) {
        if (t == null) return;
        if (level == l.size()) {
            l.add(t.val);
        }
        dfs(t.right, level + 1, l);
        dfs(t.left, level + 1, l);
    }
}
