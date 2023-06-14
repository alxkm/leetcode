package com.leetcode.easy.list;

import com.leetcode.ListNode;

public class _21_Merge_Two_Sorted_Lists {
    //https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null) return list2;

        ListNode head;
        ListNode h = new ListNode();
        head = h;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                h.next = new ListNode(list2.val);
                h = h.next;
                list2 = list2.next;
            } else {
                h.next = new ListNode(list1.val);
                h = h.next;
                list1 = list1.next;
            }
        }
        h.next = list1 != null ? list1 : list2;
        return head.next;
    }

}
