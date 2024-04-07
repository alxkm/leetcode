package com.leetcode.top.top175;

import com.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _82_Remove_Duplicates_from_Sorted_List_II {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    //82. Remove Duplicates from Sorted List II
    //FOREIGN_SOLUTION
    //TOP

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Map<Integer, Integer> fr = new HashMap<>();
        ListNode h = head;

        while (h != null) {
            fr.put(h.val, fr.getOrDefault(h.val, 0) + 1);
            h = h.next;
        }
        ListNode newHead = null;
        ListNode newList = null;
        h = head;

        while (h != null) {
            if (fr.get(h.val) > 1) {
                h = h.next;
                continue;
            }
            if (newHead == null) {
                newHead = h;
                newList = h;
            } else {
                newList.next = h;
                newList = newList.next;
            }
            h = h.next;
        }
        if (newList != null)
            newList.next = null;
        return newHead;
    }
}
