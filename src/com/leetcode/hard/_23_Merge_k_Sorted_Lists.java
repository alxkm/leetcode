package com.leetcode.hard;

import com.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _23_Merge_k_Sorted_Lists {
    //https://leetcode.com/problems/merge-k-sorted-lists/
    //23. Merge k Sorted Lists

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<ListNode>((x, y) -> (x == y) ? 1 : x.val - y.val);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode h = lists[i];
            while (h != null) {
                pq.offer(h);
                h = h.next;
            }
        }
        ListNode head = pq.poll();
        ListNode h = head;
        while (!pq.isEmpty()) {
            h.next = pq.poll();
            h = h.next;
            h.next = null;
        }
        return head;
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode h = new ListNode(-1);
            for (ListNode l: lists) {
                h = merge(h, l);
            }
            return h.next;
        }

        ListNode merge(ListNode l1, ListNode l2) {
            ListNode h = new ListNode(-1);
            ListNode dummy = h;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    h.next = new ListNode(l1.val);
                    h = h.next;
                    l1 = l1.next;
                } else if (l1.val > l2.val) {
                    h.next = new ListNode(l2.val);
                    h = h.next;
                    l2 = l2.next;
                } else {
                    h.next = new ListNode(l1.val);
                    h = h.next;
                    h.next = new ListNode(l2.val);
                    h = h.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            h.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }
}
