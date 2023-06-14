package com.leetcode.easy.list;

import com.leetcode.ListNode;

public class _83_Remove_Duplicates_from_Sorted_List {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        ListNode prev = node;
        node = node.next;
        while (node != null) {
            if (node.val == prev.val) {
                ListNode s = node;
                while (s != null && node.val == s.val) {
                    s = s.next;
                }
                prev.next = s;
                node = s;
                continue;
            }
            prev = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        var s = new _83_Remove_Duplicates_from_Sorted_List();

        ListNode l =
                new ListNode(1,
                             new ListNode(1,
                                          new ListNode(2,
                                                       new ListNode(2,
                     new ListNode(2,
                                new ListNode(3,
                                           new ListNode(4,
                                                   new ListNode(5)))
                                                                    )))
                             ));
        ListNode l1 =
                new ListNode(1,
                               new ListNode(1, new ListNode(2, new ListNode(2))));

        ListNode listNode = s.deleteDuplicates(null);
        while (listNode != null) {
            System.out.println("ELEMENT " + listNode.val);
            listNode = listNode.next;
        }

    }
}
