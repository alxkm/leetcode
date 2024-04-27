package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1022_Sum_of_Root_To_Leaf_Binary_Numbers {
    //1022. Sum of Root To Leaf Binary Numbers
    //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/

    public int sumRootToLeaf(TreeNode root) {
        List<String> l = new ArrayList<>();
        dfs(root, "", l);
        int s = 0;
        for (int i = 0; i < l.size(); i++) {
            int n = 0;
            String num = l.get(i);
            for (int j = num.length() - 1, order = 0; j >= 0; j--, order++) {
                int tmp = num.charAt(j) - '0';
                n += (tmp * Math.pow(2, order));
            }
            //System.out.println(n);
            s += n;
        }
        return s;
    }

    private void dfs(TreeNode t, String s, List<String> l) {
        if (t == null) return;
        s = s + t.val;
        if (t.left == null && t.right == null) {
            l.add(s);
            return;
        }
        dfs(t.left, s, l);
        dfs(t.right, s, l);
    }

    //foreign
    //study

    public int sumRootToLeaf1(TreeNode root) {
        return calculateSum(root, 0);
    }

    public int calculateSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return calculateSum(root.left, sum) + calculateSum(root.right, sum);
    }
}
