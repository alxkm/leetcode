package com.leetcode.easy.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.Stack;

public class _206_Reverse_Linked_List {
    //206. Reverse Linked List
    //https://leetcode.com/problems/reverse-linked-list/

    static public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> s = new Stack<>();
        ListNode l = head;
        while (l != null) {
            s.push(l);
            l = l.next;
        }

        head = s.pop();
        l = head;
        while (!s.isEmpty()) {
            l.next = s.pop();
            l = l.next;
        }
        l.next = null;
        return head;
    }


    public ListNode reverseList1(ListNode head) {
        ListNode h = head;
        Stack<ListNode> s = new Stack<>();
        while (h.next != null) {
            s.push(h);
            h = h.next;
        }
        head = s.pop();
        h = head;
        while (!s.isEmpty()) {
            h.next = s.pop();
            h = h.next;
        }
        h.next = null;
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode h = head;
        ListNode next = h.next;
        h.next = null;
        ListNode prev = h;
        h = next;
        if (h == null) return prev;

        while (h != null) {
            next = h.next;
            h.next = prev;
            prev = h;
            if (next == null) break;
            h = next;
        }

        return h;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            if (next == null) return cur;
            cur = next;
        }

        return cur;
    }

    public ListNode reverseList4(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            if (next == null) return cur;
            cur = next;
        }

        return cur;
    }

    public ListNode reverseList5(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListUtil.print(reverseList(ListUtil.of(1, 2, 3, 4, 5)));
    }
}
