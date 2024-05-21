package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _979_Distribute_Coins_in_Binary_Tree {
    //979. Distribute Coins in Binary Tree
    //https://leetcode.com/problems/distribute-coins-in-binary-tree/description/

    private int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode current) {
        if (current == null)
            return 0;

        // Calculate the coins each subtree has available to exchange
        int leftCoins = dfs(current.left);
        int rightCoins = dfs(current.right);

        // Add the total number of exchanges to moves
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        // The number of coins current has available to exchange
        return (current.val - 1) + leftCoins + rightCoins;
    }
}
