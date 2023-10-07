package com.leetcode.top.top175;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;
import java.util.Stack;

public class _61_Rotate_List {
    //https://leetcode.com/problems/rotate-list/
    //FOREIGN_SOLUTION
    //list
    //NOT_OPTIMAL
    //TOP

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int size = 0;
        ListNode h = head;

        while (h != null) {
            size++;
            h = h.next;
        }
        if (size == 1 || size == k || (k > size && k % size == 0)) return head;
        k %= size;
        int counter = 0;
        h = head;
        while (counter < size - k - 1) {
            counter++;
            h = h.next;
        }
        var h1 = h.next;
        h.next = null;
        h = h1;
        Stack<ListNode> stack = new Stack<>();
        while (h != null) {
            stack.add(h);
            h = h.next;
        }

        while (!stack.isEmpty()) {
            var e = stack.pop();
            e.next = head;
            head = e;
        }

        return head;
    }

    //better solution
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int size = 0;
        ListNode h = head;

        while (h != null) {
            size++;
            h = h.next;
        }
        if (size == 1 || size == k || (k > size && k % size == 0)) return head;
        k %= size;
        int counter = 0;
        h = head;
        while (counter < size - k - 1) {
            counter++;
            h = h.next;
        }
        var newHead = h.next;

        h.next = null;
        h = newHead;
        while (h.next != null) {
            h = h.next;
        }
        h.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        var l = ListUtil.build(List.of(1,2,3,4,5));
        var solution = new _61_Rotate_List();
        ListUtil.print(solution.rotateRight(l, 2));
    }
}
