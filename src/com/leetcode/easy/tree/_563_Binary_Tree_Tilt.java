package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _563_Binary_Tree_Tilt {
    //563. Binary Tree Tilt
    //https://leetcode.com/problems/binary-tree-tilt/

    private List<Integer> list = new ArrayList<>();

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, root.right);
        int s = 0;
        for (int n: list) s += n;
        return s;
    }

    private int dfs(TreeNode l,TreeNode r) {
        int a = 0, b = 0;

        if (l != null) a += l.val + dfs(l.left, l.right);
        if (r != null) b += r.val + dfs(r.left, r.right);
        list.add(Math.abs(a - b));

        return a + b;
    }

    //foreign
    class Solution {
        public int findTilt(TreeNode root) {
            sum(root);
            return ans;
        }

        int ans = 0;

        public int sum(TreeNode root){
            if(root == null) return 0;

            int left = sum(root.left);
            int right = sum(root.right);

            ans += Math.abs(left - right);

            return left + right + root.val;
        }
    }
}
