package com.leetcode.medium.list;

import com.leetcode.ListNode;

public class _2807_Insert_Greatest_Common_Divisors_in_Linked_List {
    //https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
    //2807. Insert Greatest Common Divisors in Linked List

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var h = head;
        while (h != null) {
            if (h.next != null) {
                var nextNode = h.next;
                int v = gcd(h.val, nextNode.val);
                h.next = new ListNode(v, nextNode);
                h = nextNode;
            } else {
                break;
            }
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0)
            b = a % (a = b);
        return a;
    }
}

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode h = head;
        ListNode prev = head;
        h = h.next;
        while (h != null) {
            int d = gcd(h.val, prev.val);
            prev.next = new ListNode(d, h);
            prev = h;
            h = h.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
