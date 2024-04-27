package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_Average_of_Levels_in_Binary_Tree {
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    //637. Average of Levels in Binary Tree
    //improve

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double size = q.size();
            int n = (int)size;
            double sum = 0;
            while (n-- > 0) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
                sum += t.val;
            }
            list.add(sum / size);
        }
        return list;
    }


    //foreign
    //study
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, res, count);
        for(int i = 0 ; i < res.size() ; i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
    private void average(TreeNode node, int i, List<Double> sum, List<Integer> count) {
        if(node == null) {
            return;
        }
        if(i < sum.size()) {
            sum.set(i, sum.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        average(node.left, i + 1, sum, count);
        average(node.right, i + 1, sum, count);
    }
}
