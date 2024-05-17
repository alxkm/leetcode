package com.leetcode.medium.list;

import com.leetcode.ListNode;

public class _2816_Double_a_Number_Represented_as_a_Linked_List {
    //2816. Double a Number Represented as a Linked List
    //https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/

    public ListNode doubleIt(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (true) {
            var temp = cur.next;
            cur.next = prev;
            prev = cur;
            if (temp == null) break;
            cur = temp;
        }

        int r = 0;
        ListNode h = cur;
        while (h != null) {
            r += h.val * 2;
            h.val = r % 10;
            r /= 10;
            if (h.next == null && r > 0) {
                h.next = new ListNode(r);
                break;
            }
            h = h.next;
        }

        prev = null;

        while (true) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            if (temp == null) break;
            cur = temp;
        }

        return cur;
    }
}
