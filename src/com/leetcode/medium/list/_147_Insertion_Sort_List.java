package com.leetcode.medium.list;

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _147_Insertion_Sort_List {
    //147. Insertion Sort List
    //https://leetcode.com/problems/insertion-sort-list/

    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;

        while (head != null) {

            var insertNode = head;
            head = head.next;
            insertNode.next = null;

            if (insertNode.val <= newHead.val) {
                insertNode.next = newHead;
                newHead = insertNode;
                continue;
            }

            var sorted = newHead.next;
            if (sorted == null) {
                newHead.next = insertNode;
                continue;
            }

            ListNode prev = newHead;
            while (sorted != null) {

                if (insertNode.val >= prev.val && insertNode.val <= sorted.val) {
                    prev.next = insertNode;
                    insertNode.next = sorted;
                    break;
                }

                if (sorted.next == null) {
                    sorted.next = insertNode;
                    break;
                }

                prev = sorted;
                sorted = sorted.next;
            }
        }

        return newHead;
    }

}
