package com.leetcode.hard;

import com.leetcode.TreeNode;

public class _1028_Recover_a_Tree_From_Preorder_Traversal {
    //https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
    //1028. Recover a Tree From Preorder Traversal

    int i = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, 0);
    }

    public TreeNode dfs(String s, int level) {
        if (i >= s.length()) return null;
        int dash = 0, j = i;

        while (j < s.length() && s.charAt(j) == '-') {
            dash++;
            j++;
        }
        if (dash == level) {
            i = j;
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            var t = new TreeNode(Integer.parseInt(sb.toString()));
            t.left = dfs(s, level + 1);
            t.right = dfs(s, level + 1);
            return t;
        }
        return null;
    }

    public static void main(String[] args) {
        var sol = new _1028_Recover_a_Tree_From_Preorder_Traversal();
        System.out.println(sol.recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}
