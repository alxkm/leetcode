package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    //1457. Pseudo-Palindromic Paths in a Binary Tree
    //https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/

    int palindromeCounter = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        dfs(root, new int[10]);
        return palindromeCounter;
    }

    void dfs(TreeNode t, int[] map) {
        if (t == null) {
            return;
        }

        map[t.val]++;

        if (t.left == null && t.right == null) {
            int odd = 0;
            for (int n: map) {
                if ((n != 0) && (n == 1 || n % 2 != 0)) odd++;
            }
            if (odd <= 1) {
                palindromeCounter++;
            }
        }

        dfs(t.left, map);
        dfs(t.right, map);
        map[t.val]--;
    }
}
