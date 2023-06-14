package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static ListNode build(List<Integer> list) {
        if (list.size() == 0) return null;
        ListNode head = new ListNode(list.get(0));
        ListNode h = head;
        for (int i = 1; i < list.size(); i++) {
            h.next = new ListNode(list.get(i));
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
