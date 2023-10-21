package com.leetcode.medium.list;

import com.leetcode.ListNode;

public class _1669_Merge_In_Between_Linked_Lists {
    //https://leetcode.com/problems/merge-in-between-linked-lists/
    //1669. Merge In Between Linked Lists

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null, end = null;
        int i = 0;
        ListNode h = list1;
        while (h != null) {
            if (i + 1 == a) {
                start = h;
            }
            if (i == b) {
                end = h;
            }
            h = h.next;
            i++;
        }

        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }

        start.next = list2;
        end2.next = end.next;
        return list1;
    }
}
