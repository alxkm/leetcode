package com.leetcode.easy.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;

public class _203_Remove_Linked_List_Elements {
   static public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;

        ListNode h = head.next;
        ListNode prev = head;

        while (h != null ) {
            if (h.val == val) {
                prev.next = h.next;
            } else{
                prev = h;
            }
            h = h.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.build(List.of(1, 1, 1, 1, 3, 3, 1, 1, 5, 6, 1, 1));
        head = removeElements(head, 1);
        ListUtil.print(head);
    }
}
