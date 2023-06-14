package com.leetcode.top.list;

import com.leetcode.ListNode;

public class _19_Remove_Nth_Node_From_End_of_List {
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    //19. Remove Nth Node From End of List

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode copy = head;
        int size = 0;
        while (copy != null) {
            size++;
            copy = copy.next;
        }
        if (n == 1 && size == 1) return null;
        if (n == size) {
            head = head.next;
            return head;
        }
        int left = size - n;
        copy = head;
        int i = 1;
        while (i < left) {
            i++;
            copy = copy.next;
        }
        // System.out.println(copy.val);
        // System.out.println(n);
        // System.out.println(i);
        if (copy.next != null)
            copy.next = copy.next.next;
        return head;
    }
}
