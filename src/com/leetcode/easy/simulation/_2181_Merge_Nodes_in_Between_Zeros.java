package com.leetcode.easy.simulation;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _2181_Merge_Nodes_in_Between_Zeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode l = head;
        List<Integer> list = new ArrayList<>();
        int zero = 0;
        int sum = 0;
        while (l != null) {
            if (l.val == 0) {
                zero++;
                if (zero == 2) {
                    if (sum != 0) {
                        list.add(sum);
                        sum = 0;
                    }
                    zero--;
                }
            } else if (zero == 1){
                sum += l.val;
            }
            l = l.next;
        }
        if (list.size() == 0) return null;
        ListNode a = new ListNode();
        head = a;
        for (int n : list) {
            a.next = new ListNode();
            a = a.next;
            a.val = n;
        }
        return head.next;
    }
}
