package com.leetcode.medium.list;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _2487_Remove_Nodes_From_Linked_List {
    //https://leetcode.com/problems/remove-nodes-from-linked-list/
    //2487. Remove Nodes From Linked List

    public ListNode removeNodes(ListNode head) {
        ListNode h = head;
        List<Integer> l = new ArrayList<>();
        while (h != null) {
            l.add(h.val);
            h = h.next;
        }
        int[] prefix = new int[l.size()];
        prefix[l.size() - 1] = l.get(l.size() - 1);
        for (int i = l.size() - 2; i >= 0; i--) {
            prefix[i] = Math.max(l.get(i), prefix[i + 1]);
        }

        ListNode newHead = new ListNode();
        h = newHead;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) >= prefix[i]) {
                h.next = new ListNode(l.get(i));
                h = h.next;
            }
        }
        return newHead.next;
    }
}
