package com.leetcode.medium.stack;

import java.util.Stack;

public class _445_Add_Two_Numbers_II {
    //https://leetcode.com/problems/add-two-numbers-ii/
    //TOP

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                st1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                st2.add(l2.val);
                l2 = l2.next;
            }
        }
        int curry = 0;
        Stack<Integer> st = new Stack<>();
        while (!st1.isEmpty() || !st2.isEmpty()) {
            int a = 0;
            if (!st1.isEmpty()) {
                a = st1.pop();
            }
            int b = 0;
            if (!st2.isEmpty()) {
                b = st2.pop();
            }

            if ((a + b + curry) >= 10) {
                //System.out.println("a " + a + " b " + b + " curry " + curry);
                int n = a + b + curry;
                curry = n / 10;
                st.add(n % 10);
            } else {
                st.add(a + b + curry);
                curry = 0;
            }
        }
        if (curry > 0) {
            st.add(curry);
        }
        ListNode l = new ListNode();
        ListNode h = l;

        while (!st.isEmpty()) {
            l.next = new ListNode(st.pop());
            l = l.next;
        }

        return h.next;
    }
}
