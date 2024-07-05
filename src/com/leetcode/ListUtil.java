package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static ListNode of(int... ar) {
        if (ar == null || ar.length == 0) return null;

        ListNode head = new ListNode(ar[0]);
        ListNode h = head;
        for (int i = 1; i < ar.length; i++) {
            h.next = new ListNode(ar[i]);
            h = h.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        System.out.println(list);
    }
}
