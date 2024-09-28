package com.leetcode.top.list;

import com.leetcode.ListNode;

public class _725_Split_Linked_List_in_Parts {
    //https://leetcode.com/problems/split-linked-list-in-parts/
    //725. Split Linked List in Parts
    //https://leetcode.com/problems/split-linked-list-in-parts/description/?envType=daily-question&envId=2024-09-08

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];
        ListNode[] ar = new ListNode[k];
        ListNode h = head;
        int size = 1;
        while ((h = h.next) != null) size++;
        int q = size / k;
        int r = size % k;
        int i = 0;
        while (head != null) {
            h = head;
            size = q;
            if (r > 0) {
                size++;
                r--;
            }
            while (size > 0) {
                size--;
                if (size > 0) {
                    h = h.next;
                }
            }
            ar[i++] = head;
            head = h.next;
            h.next = null;
        }
        return ar;
    }

    public ListNode[] splitListToParts1(ListNode head, int k) {
        int size = 0;
        ListNode h = head;

        while (h != null) {
            h = h.next;
            size++;
        }
        int r = size % k;
        int partReference = size / k;
        if (size <= k) {
            partReference = 1;
            r = 0;
        }

        ListNode[] l = new ListNode[k];
        h = head;
        for (int i = 0; i < k; i++) {
            int j = 0;
            if (h != null) {
                l[i] = h;
            }
            int part = partReference;
            if (r > 0) {
                part++;
                r--;
            }
            while (h != null && j < part) {
                j++;
                if (j == part) {
                    ListNode tmp = h.next;
                    h.next = null;
                    h = tmp;
                } else {
                    h = h.next;
                }
            }
        }

        return l;
    }
}
