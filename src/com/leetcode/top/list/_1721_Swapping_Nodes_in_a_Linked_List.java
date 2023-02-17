package com.leetcode.top.list;

public class _1721_Swapping_Nodes_in_a_Linked_List {
    //https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
    //1721. Swapping Nodes in a Linked List

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        ListNode h = head, first = null, second = null;
        int size = 1;
        while (h != null) {
            h = h.next;
            if (h != null) {
                size++;
                if (size == k)  first = h;
            }
        }
        if (size == 1) return head;
        if (k == 1) first = head;
        //System.out.println(first.val);
        int l = size - k;
        h = head;
        while (l > 0) {
            h = h.next;
            l--;
        }
        //System.out.println(size);
        //System.out.println(h.val);
        int temp = first.val;
        first.val = h.val;
        h.val = temp;
        return head;
    }
}
