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

    class Solution {
        String s;
        int i = 0;
        public TreeNode recoverFromPreorder(String traversal) {
            s = traversal;
            String num = "";
            int k = 0;
            while (k < s.length() && s.charAt(k) != '-') {
                num += s.charAt(k);
                k++;
            }
            TreeNode root = new TreeNode(Integer.parseInt(num));
            i = k;
            dfs(root, 1, true);
            dfs(root, 1, false);
            return root;
        }

        private void dfs(TreeNode t, int cur, boolean dirLeft) {
            if (s.length() == i) return;

            int j = i;
            int counter = 0;
            while (j < s.length() && s.charAt(j) == '-') {
                j++;
                counter++;
            }

            if (counter == cur) {
                String num = "";
                int k = j;
                while (k < s.length() && s.charAt(k) != '-') {
                    num += s.charAt(k);
                    k++;
                }
                i = k;
                if (dirLeft) {
                    t.left = new TreeNode(Integer.parseInt(num));
                    dfs(t.left, cur + 1, true);
                    dfs(t.left, cur + 1, false);
                } else {
                    t.right = new TreeNode(Integer.parseInt(num));
                    dfs(t.right, cur + 1, true);
                    dfs(t.right, cur + 1, false);
                }
            }
        }
    }

    public static void main(String[] args) {
        var sol = new _1028_Recover_a_Tree_From_Preorder_Traversal();
        System.out.println(sol.recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}
