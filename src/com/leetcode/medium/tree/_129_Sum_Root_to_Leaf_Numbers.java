package com.leetcode.medium.tree;

import com.leetcode.ArrayUtil;
import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class _129_Sum_Root_to_Leaf_Numbers {
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    //129. Sum Root to Leaf Numbers
    //TREE
    //TOP

//    public int sumNumbers(TreeNode root) {
//       return dfs(root, 0);
//    }
//
//    private int dfs(TreeNode t, int sum) {
//        if (t == null) return 0;
//        if (t.left == null && t.right == null) return t.val + sum * 10;
//        return dfs(t.left, t.val + sum * 10) + dfs(t.right, t.val + sum * 10);
//    }


    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }

    public int dfs(TreeNode t, String a) {
        if (t == null) {
            return 0;
        }
        if (t.right == null && t.left == null) {
            return Integer.valueOf(a + t.val);
        }

        int first = dfs(t.left, a + t.val);
        int second = dfs(t.right, a + t.val);

        return first + second;
    }

    public int sumNumbers1(TreeNode root) {
        return dfs1(root, 0);
    }

    public int dfs1(TreeNode t, int sum) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return sum * 10 + t.val;

        return dfs1(t.left, sum * 10 + t.val) + dfs1(t.right, sum * 10 + t.val);
    }

    public static void main(String[] args) {
        var sol = new _129_Sum_Root_to_Leaf_Numbers();
        Integer[] of = ArrayUtil.ofInteger(1,0);
        System.out.println(sol.sumNumbers(TreeUtil.formTree(of)));
    }
}
