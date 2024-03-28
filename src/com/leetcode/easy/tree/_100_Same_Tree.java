package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _100_Same_Tree {
    //https://leetcode.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        traversalInorder(p, l1);
        traversalInorder(q, l2);

        if (l1.size() != l2.size()) return false;

        for (int i = 0; i < l1.size(); i++) {
            if(l1.get(i) == null && l2.get(i) == null) continue;
            if(l1.get(i) == null && l2.get(i) != null) return false;
            if(l1.get(i) != null && l2.get(i) == null) return false;
            if(!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }

    private void traversalInorder(TreeNode p, List<Integer> l) {
        l.add(p == null ? null : p.val);
        if (p == null) return;
        traversalInorder(p.left, l);
        traversalInorder(p.right, l);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
