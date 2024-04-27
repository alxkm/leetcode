package com.leetcode.medium.tree;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _109_Convert_Sorted_List_to_Binary_Search_Tree_ {
    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    //109. Convert Sorted List to Binary Search Tree

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h.val);
            h = h.next;
        }
        return tree(list, 0, list.size() - 1);
    }

    private TreeNode tree(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;

        TreeNode t = new TreeNode(list.get(m));
        t.left = tree(list, l, m - 1);
        t.right = tree(list, m + 1, r);

        return t;
    }
}
