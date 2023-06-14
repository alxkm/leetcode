package com.leetcode.easy.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;
import java.util.Stack;

public class _206_Reverse_Linked_List {
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

    public static void main(String[] args) {
        ListUtil.print(reverseList(ListUtil.build(List.of(1, 2, 3, 4, 5))));
    }
}
