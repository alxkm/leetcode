package com.leetcode.medium.tree;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _538_Convert_BST_to_Greater_Tree {
    //1038. Binary Search Tree to Greater Sum Tree
    //https://leetcode.com/problems/convert-bst-to-greater-tree/description/
    //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

    List<Integer> l = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {

        dfs(root);
        Collections.sort(l);
        dfs1(root);
        return root;
    }

    private void dfs(TreeNode t) {
        if (t == null) return;
        l.add(t.val);
        dfs(t.right);
        dfs(t.left);
    }

    private void dfs1(TreeNode t) {
        if (t == null) return;
        int sum = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) > t.val) sum += l.get(i);
        }
        t.val += sum;

        dfs1(t.left);
        dfs1(t.right);
    }

    class Solution1 {
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] pr;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) return root;
            dfs(root);
            Collections.sort(l);
            int n = l.size();
            pr = new int[l.size()];
            pr[n - 1] = l.get(n - 1);

            map.put(l.get(n - 1), n - 1);
            for (int i = n - 2; i >= 0; i--) {
                if (l.get(i) == l.get(i + 1)) pr[i] = pr[i + 1];
                else pr[i] = l.get(i) + pr[i + 1];
                map.put(l.get(i), i);
            }

            dfs1(root);
            return root;
        }

        private void dfs(TreeNode t) {
            if (t == null) return;
            l.add(t.val);
            dfs(t.right);
            dfs(t.left);
        }

        private void dfs1(TreeNode t) {
            if (t == null) return;
            int sum = 0;
            int i = map.get(t.val);
            t.val = pr[i];

            dfs1(t.left);
            dfs1(t.right);
        }
    }

    class Solution2 {
        List<Integer> l = new ArrayList<>();
        int[] map = new int[20100];
        int[] pr;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) return root;
            dfs(root);
            Collections.sort(l);
            int n = l.size();
            pr = new int[l.size()];
            pr[n - 1] = l.get(n - 1);

            map[f(l.get(n - 1))] = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (l.get(i) == l.get(i + 1)) pr[i] = pr[i + 1];
                else pr[i] = l.get(i) + pr[i + 1];
                map[f(l.get(i))] = i;
            }

            dfs1(root);
            return root;
        }

        private void dfs(TreeNode t) {
            if (t == null) return;
            l.add(t.val);
            dfs(t.right);
            dfs(t.left);
        }

        private int f(int n) {
            if (n < 0) return 10001 + (-1 * n);
            return n;
        }

        private void dfs1(TreeNode t) {
            if (t == null) return;
            int sum = 0;
            int i = map[f(t.val)];
            t.val = pr[i];

            dfs1(t.left);
            dfs1(t.right);
        }
    }

    class Solution3 {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            dfs(root);
            return root;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;

            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
        }
    }
    public static void main(String[] args) {
        var sol = new _538_Convert_BST_to_Greater_Tree();
        sol.convertBST(TreeUtil.formTree(new Integer[] {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8}));
    }
}
