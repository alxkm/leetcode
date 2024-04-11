package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2415_Reverse_Odd_Levels_of_Binary_Tree {
    //2415. Reverse Odd Levels of Binary Tree
    //https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean isOdd = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (isOdd) {
                    list.add(t);
                }
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }

            if (isOdd) {
                for (int i = 0; i < list.size() / 2; i++) {
                    int a = list.get(list.size() - i - 1).val;
                    list.get(list.size() - i - 1).val = list.get(i).val;
                    list.get(i).val = a;
                }
                isOdd = false;
            } else {
                isOdd = true;
            }
        }

        return root;
    }
}
