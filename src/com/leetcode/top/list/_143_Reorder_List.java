package com.leetcode.top.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _143_Reorder_List {
    //https://leetcode.com/problems/reorder-list/
    //143. Reorder List

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        var tmp = head.next;
        int size = 0;
        while (tmp != null) {
            q.offer(tmp.val);
            s.push(tmp.val);
            tmp = tmp.next;
            size++;
        }
        head = head.next;
        while (size > 0) {
            int ln = s.pop();
            head.val = ln;
            head = head.next;
            size--;
            if (size > 0) {
                int l1 = q.poll();
                head.val = l1;
                size--;
                head = head.next;
            }
        }
    }
}
