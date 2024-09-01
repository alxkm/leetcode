package com.leetcode.medium.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public ListNode removeNodes1(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode h = head;
        st.push(h);
        while (h != null) {
            while (!st.isEmpty() && st.peek().val < h.val) {
                st.pop();
            }
            st.push(h);
            h = h.next;
        }
        h = new ListNode();
        head = h;
        for (int i = 0; i < st.size(); i++) {
            h.next = st.get(i);
            h = h.next;
            h.next = null;
        }
        return head.next;
    }

    public static void main(String[] args) {
        var sol = new _2487_Remove_Nodes_From_Linked_List();
        System.out.println(sol.removeNodes1(ListUtil.of(5, 2, 13, 3, 8)));
    }
}
