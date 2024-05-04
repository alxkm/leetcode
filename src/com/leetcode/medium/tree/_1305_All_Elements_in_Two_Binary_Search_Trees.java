package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1305_All_Elements_in_Two_Binary_Search_Trees {
    //1305. All Elements in Two Binary Search Trees
    //https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l = new ArrayList<>();
        dfs(root1, l);
        dfs(root2, l);
        Collections.sort(l);
        return l;
    }

    private void dfs(TreeNode t, List<Integer> l) {
        if (t == null) return;
        l.add(t.val);
        dfs(t.left, l);
        dfs(t.right, l);
    }
}
