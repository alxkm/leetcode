package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _2265_Count_Nodes_Equal_to_Average_of_Subtree {
    //https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
    //2265. Count Nodes Equal to Average of Subtree

    public int averageOfSubtree(TreeNode root) {
        int[] arr = new int[] {0, 0, 0};
        dfs(root, arr);
        return arr[2];
    }

    private void dfs(TreeNode t, int[] ar) {
        if (t == null) return;

        if (t.right == null && t.left == null) {
            ar[0] += t.val;
            ar[1]++;
            ar[2]++;
            return;
        }
        int[] l = new int[3];
        int[] r = new int[3];

        dfs(t.left, l);
        dfs(t.right, r);

        int lrSum = l[0] + r[0];
        int lrCounter = l[1] + r[1];
        int lr = l[2] + r[2];

        if (t.val == (lrSum + t.val) / (lrCounter + 1)) {
            ar[2]++;
        }

        ar[0] += t.val + lrSum;
        ar[1] = (1 + lrCounter);
        ar[2] += lr;
    }

    public static void main(String[] args) {
        var sol = new _2265_Count_Nodes_Equal_to_Average_of_Subtree();
        TreeNode t = new TreeNode(
            4, new TreeNode(8,
                new TreeNode(0), new TreeNode(1))
                ,
                new TreeNode(5, null, new TreeNode(6))
        );


        System.out.println(sol.averageOfSubtree(t));
    }
}
