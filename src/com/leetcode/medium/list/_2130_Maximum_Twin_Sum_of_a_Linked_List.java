package com.leetcode.medium.list;

import com.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _2130_Maximum_Twin_Sum_of_a_Linked_List {
    //https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    //todo todo
    //list

    public int pairSum(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode h = head;

        for (int i = 0; h != null; i++) {
            map.put(i, h);
            h = h.next;
        }

        int max = 0;
        h = head;
        int n = map.size();
        for (int i = 0; h != null; i++) {
            var l = map.get(n - 1 - i);
            if (l != null) {
                max = Math.max(max, h.val + l.val);
            }
            h = h.next;
        }

        return max;
    }
}
