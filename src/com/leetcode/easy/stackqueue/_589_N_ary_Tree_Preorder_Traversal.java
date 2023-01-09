package com.leetcode.easy.stackqueue;

import java.util.ArrayList;
import java.util.List;

public class _589_N_ary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    private void dfs(Node root, List<Integer> l) {
        if (root == null) return;
        l.add(root.val);
        for (Node n : root.children) dfs(n, l);
    }
}
