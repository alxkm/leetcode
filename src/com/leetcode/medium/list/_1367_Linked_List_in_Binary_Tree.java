package com.leetcode.medium.list;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1367_Linked_List_in_Binary_Tree {
    //1367. Linked List in Binary Tree
    //https://leetcode.com/problems/linked-list-in-binary-tree/description/
    //but first one is short and tricky

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfsTraverse(root, head);
    }

    boolean dfs(ListNode h, TreeNode t) {
        if (h == null) return true;
        if (t == null || t.val != h.val) return false;
        return dfs(h.next, t.left) || dfs(h.next, t.right);
    }

    boolean dfsTraverse(TreeNode t, ListNode h) {
        if (t == null) return false;
        boolean ans = false;

        if (t.val == h.val) {
            if (h.next == null) ans = true;
            else if (t.right != null && t.right.val == h.next.val) ans = dfs(h, t);
            else if (t.left != null && t.left.val == h.next.val) ans = dfs(h, t);
        }
        if (ans) return true;

        return dfsTraverse(t.left, h) || dfsTraverse(t.right, h);
    }

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            List<TreeNode> l = new ArrayList<>();
            dfsCollect(l, root, head);
            for (var t: l) {
                if (dfs(head, t)) return true;
            }
            return false;
        }

        boolean dfs(ListNode h, TreeNode t) {
            if (h == null) return true;
            if (t == null || t.val != h.val) return false;
            return dfs(h.next, t.left) || dfs(h.next, t.right);
        }

        void dfsCollect(List<TreeNode> l, TreeNode t, ListNode h) {
            if (t == null) return;
            if (t.val == h.val) {
                if (h.next == null) l.add(t);
                else if (t.right != null && t.right.val == h.next.val) l.add(t);
                else if (t.left != null && t.left.val == h.next.val) l.add(t);
            }
            dfsCollect(l, t.left, h);
            dfsCollect(l, t.right, h);
        }
    }

    //foreign solution
    class Solution1 {
        public boolean isSubPath(ListNode head, TreeNode root) {
            return dfs(head, head, root);
        }

        boolean dfs(ListNode head, ListNode cur, TreeNode root) {
            if(cur == null) return true;
            if(root == null) return false;
            if(cur.val == root.val) cur = cur.next;
            else if (head.val == root.val) head = head.next;
            else cur = head;
            return dfs(head, cur, root.left) || dfs(head, cur, root.right);
        }

    }
}
