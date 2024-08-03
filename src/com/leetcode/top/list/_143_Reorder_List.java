package com.leetcode.top.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _143_Reorder_List {
    //https://leetcode.com/problems/reorder-list/
    //143. Reorder List

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

    public static void reorderList1(ListNode head) {
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }
        if (size < 3) return;
        ListNode l2 = head;
        for (int i = 0; i < size / 2 - 1; i++) l2 = l2.next;

        ListNode l2Tmp = l2;
        if (size % 2 != 0) {
            l2Tmp = l2Tmp.next;

        }
        l2 = l2Tmp.next;
        l2Tmp.next = null;
        ListNode cur = head;

        ListNode prev = null;
        while (l2 != null) {
            ListNode next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }

        l2 = prev;

        for (int i = 0; i < size / 2; i++) {
            ListNode next = cur.next;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
            cur.next = next;
            cur = cur.next;
        }
    }

    public static void reorderList3(ListNode head) {
        if (head.next == null) {
            return;
        }
        reorderList3(head, head.next);
    }

    public static ListNode reorderList3(ListNode head, ListNode curr) {
        ListNode temp;
        if (curr.next != null) {
            temp = reorderList3(head, curr.next);
        } else {
            temp = head;
        }
        if(temp == null) {
            return null;
        }
        if (temp == curr  || temp.next == curr) {
            curr.next=null;
            return null;
        }

        curr.next = temp.next;
        temp.next = curr;
        return curr.next;
    }

    public static void main(String[] args) {
        reorderList3(ListUtil.of(1,2,3,4,5));
    }
}
