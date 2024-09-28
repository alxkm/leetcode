package com.leetcode.medium.list;

import com.leetcode.ListNode;

public class _3217_Delete_Nodes_From_Linked_List_Present_in_Array {
    //3217. Delete Nodes From Linked List Present in Array
    //https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/

    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for (int n: nums) max = Math.max(n, max);
        boolean[] set = new boolean[max + 1];
        for (int n: nums) set[n] = true;

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode l = h;
        while (h != null && h.next != null) {
            if (h.next.val < max + 1 && set[h.next.val]) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return l.next;
    }
}
