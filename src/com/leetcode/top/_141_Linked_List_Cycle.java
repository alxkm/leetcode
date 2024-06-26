package com.leetcode.top;

import com.leetcode.ListNode;

public class _141_Linked_List_Cycle {
    //141. Linked List Cycle
    //https://leetcode.com/problems/linked-list-cycle/

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
