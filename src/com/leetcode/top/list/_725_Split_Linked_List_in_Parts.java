package com.leetcode.top.list;

import com.leetcode.ListNode;

public class _725_Split_Linked_List_in_Parts {
    //https://leetcode.com/problems/split-linked-list-in-parts/
    //725. Split Linked List in Parts

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];
        ListNode[] ar = new ListNode[k];
        ListNode h = head;
        int size = 1;
        while ((h = h.next) != null) size++;
        int q = size / k;
        int r = size % k;
        int i = 0;
        while (head != null) {
            h = head;
            size = q;
            if (r > 0) {
                size++;
                r--;
            }
            while (size > 0) {
                size--;
                if (size > 0) {
                    h = h.next;
                }
            }
            ar[i++] = head;
            head = h.next;
            h.next = null;
        }
        return ar;
    }
}
