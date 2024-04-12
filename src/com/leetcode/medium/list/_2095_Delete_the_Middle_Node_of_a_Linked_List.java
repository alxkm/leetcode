package com.leetcode.medium.list;

import com.leetcode.ListNode;

public class _2095_Delete_the_Middle_Node_of_a_Linked_List {
    //2095. Delete the Middle Node of a Linked List
    //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

    public ListNode deleteMiddle(ListNode head) {
        ListNode h = head;
        if (h.next == null) return null;
        int size = 0;
        while (h != null) {
            size++;
            h = h.next;
        }
        size /= 2;
        ListNode prev = head;
        h = head.next;
        size--;
        while (size-- > 0) {
            prev = h;
            h = h.next;
        }
        prev.next = h.next;
        return head;
    }
}
