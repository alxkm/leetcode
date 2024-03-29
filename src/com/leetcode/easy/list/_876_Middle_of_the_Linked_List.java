package com.leetcode.easy.list;

import com.leetcode.ListNode;

public class _876_Middle_of_the_Linked_List {
    //876. Middle of the Linked List
    //https://leetcode.com/problems/middle-of-the-linked-list/


    static public ListNode middleNode(ListNode head) {
        ListNode l = head;
        int size = 0;
        while (l != null) {
            size++;
            l = l.next;
        }

        int middle = size % 2 == 0 ? (size / 2) + 1 : ((size - 1) / 2) + 1;

        int i = 0;
        l = head;
        while (l != null) {
            i++;
            if (i == middle) return l;
            l = l.next;
        }
        return null;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode h = head;
        int size = 0;

        while (h != null) {
            size++;
            h = h.next;
        }

        size /= 2;
        h = head;

        while (size-- > 0) {
            h = h.next;
        }
        return h;
    }
}
