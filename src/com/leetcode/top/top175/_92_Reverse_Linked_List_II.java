package com.leetcode.top.top175;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;
import java.util.Stack;

public class _92_Reverse_Linked_List_II {
    //https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) return head;
        var h = head;
        Stack<ListNode> stack = new Stack<>();
        int i = 1;
        if (left != 1) {
            while (++i < left) {
                h = h.next;
            }
            var ln = h;
            h = h.next;
            while (i++ <= right) {
                stack.add(h);
                h = h.next;
            }
            while (!stack.isEmpty()) {
                ln.next = stack.pop();
                ln = ln.next;
            }
            ln.next = h;
        } else {
            while (h != null) {
                stack.add(h);
                h = h.next;
                if (i++ == right) break;
            }
            head = stack.pop();
            var rn = h;
            h = head;
            while (!stack.isEmpty()) {
                h.next = stack.pop();
                h = h.next;
            }
            h.next = rn;
        }
        return head;
    }

    public static void main(String[] args) {
        var solution = new _92_Reverse_Linked_List_II();
        ListNode list = ListUtil.build(List.of(1, 2, 3, 4, 5));
        int left = 2, right = 4;
        //int left = 1, right = 5;
        ListUtil.print(solution.reverseBetween(list, left, right));
    }
}
