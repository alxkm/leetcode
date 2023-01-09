package com.leetcode.easy.stackqueue;

import java.util.ArrayList;
import java.util.List;

public class _590_N_ary_Tree_Postorder_Traversal {
    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    private void dfs(Node root, List<Integer> l) {
        if (root == null) return;

        for (Node n : root.children) {
            dfs(n, l);
        }

        l.add(root.val);
    }
}
