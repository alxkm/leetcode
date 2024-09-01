package com.leetcode.top.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.LinkedList;
import java.util.List;

public class _86_Partition_List {
    //https://leetcode.com/problems/partition-list/
    //86. Partition List

    public ListNode partition(ListNode head, int x) {
        List<ListNode> before = new LinkedList<>();
        List<ListNode> after = new LinkedList<>();

        ListNode h = head;
        ListNode node = null;

        while (h != null) {
            if (h.val == x) {
                node = h;
            } else {
                if (h.val < x) {
                    before.add(h);
                } else {
                    after.add(h);
                }
            }
            h = h.next;
        }
        head = null;
        if (before.size() != 0) {
            head = before.get(0);
            before.remove(0);
            h = head;
            for (ListNode listNode : before) {
                h.next = listNode;
                h = h.next;
            }
            if (node != null) {
                h.next = node;
                h = h.next;
            }
            for (ListNode listNode : after) {
                h.next = listNode;
                h = h.next;
            }
        } else {
            if (node != null) {
                head = node;
                h = node;
                h = h.next;
                for (int i = 0; i < after.size(); i++) {
                    h.next = after.get(i);
                    h = h.next;
                }
            } else {
                head = after.get(0);
                h = head;
                after.remove(0);
                for (int i = 0; i < after.size(); i++) {
                    h.next = after.get(i);
                    h = h.next;
                }
            }
        }

        h.next = null;

        return head;
    }

    public static void main(String[] args) {
        var solution = new _86_Partition_List();
        solution.partition(ListUtil.of(1, 4, 3, 2, 5, 2), 3);
    }
}
