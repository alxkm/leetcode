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

    public TreeNode reverseOddLevels1(TreeNode root) {
        if (root == null) return null;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            if (level % 2 != 0) {
                for (int i = 0, j = q.size() - 1; i < j; i++, j--) {
                    int tmp = ((LinkedList<TreeNode>)q).get(i).val;
                    ((LinkedList<TreeNode>)q).get(i).val = ((LinkedList<TreeNode>)q).get(j).val;
                    ((LinkedList<TreeNode>)q).get(j).val = tmp;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t.left != null) {
                    q.offer(t.left);
                    q.offer(t.right);
                }
            }
            level++;
        }
        return root;
    }

    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            traverseDFS(root.left, root.right, 0);
            return root;
        }

        private void traverseDFS(TreeNode left, TreeNode right, int level) {
            if (left == null || right == null) {
                return;
            }

            if (level % 2 == 0) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }

            traverseDFS(left.left, right.right, level + 1);
            traverseDFS(left.right, right.left, level + 1);
        }
    }
}
