package com.leetcode.medium.tree;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class _1609_Even_Odd_Tree {
    //1609. Even Odd Tree
    //https://leetcode.com/problems/even-odd-tree/

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEven = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = -1;
            while (size-- > 0) {
                var t = q.poll();
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);

                if (isEven && (prev != -1 && prev >= t.val)) return false;
                else if (!isEven && (prev != -1 && prev <= t.val)) return false;

                if (isEven && t.val % 2 == 0) return false;
                else if (!isEven && t.val % 2 != 0) return false;
                prev = t.val;
            }
            isEven = !isEven;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new _1609_Even_Odd_Tree();
        sol.isEvenOddTree(TreeUtil.formTree(new Integer[] {5,4,2,3,3,7}));
    }
}
