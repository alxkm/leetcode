package com.leetcode.easy.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;
import java.util.Stack;

public class _234_Palindrome_Linked_List {
    //234. Palindrome Linked List
    //https://leetcode.com/problems/palindrome-linked-list/

    static public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String f;
        String s;

        int size = sb.length();
        if (size % 2 == 0) {
            f = sb.substring(0, (size / 2));
            s = sb.substring((size / 2));
        } else {
            f = sb.substring(0, (size / 2));
            s = sb.substring((size / 2) + 1);
        }
        sb = new StringBuilder(f);
        sb.reverse();

        return sb.toString().equals(s);
    }

    static public boolean isPalindrome1(ListNode head) {
        ListNode h = head;
        int size = 0;
        while (h != null) {
            h = h.next;
            size++;
        }
        h = head;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < (size / 2); i++) {
            st.push(h.val);
            h = h.next;
        }

        if (size % 2 != 0) {
            h = h.next;
        }

        for (int i = 0; i < (size / 2); i++) {
            if (st.pop() != h.val) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode h = head;
        int size = 0;
        while (h != null) {
            size++;
            h = h.next;
        }
        if (size == 1) return true;

        h = head;
        for (int i = 0; i < size / 2 - 1; i++) h = h.next;
        ListNode l1 = h;
        ListNode l2 = h.next;
        l1.next = null;

        if (size % 2 != 0) l2 = l2.next;

        h = head;
        ListNode prev = null;

        while (h != null) {
            ListNode temp = h.next;
            h.next = prev;
            prev = h;
            h = temp;
        }
        l1 = prev;

        while (l1 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(ListUtil.build(List.of(1, 2, 2, 1))));
    }
}
