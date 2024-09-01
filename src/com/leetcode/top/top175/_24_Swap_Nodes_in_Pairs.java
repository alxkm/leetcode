package com.leetcode.top.top175;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class _24_Swap_Nodes_in_Pairs {
    //https://leetcode.com/problems/swap-nodes-in-pairs/description/
    //24. Swap Nodes in Pairs
    //Jun 16, 2023 12:41
    //time 1
    //foreign_solution

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        List<ListNode> first = new ArrayList<>();
        List<ListNode> second = new ArrayList<>();
        var h = head;
        int i = 1;

        while (h != null) {
            if (i % 2 == 0) {
                second.add(h);
            } else {
                first.add(h);
            }
            i++;
            h = h.next;
        }

        ListNode cur;
        if (!second.isEmpty()) {
            cur = second.get(0);
            second.remove(0);
        } else {
            return head;
        }
        head = cur;
        while (!first.isEmpty() || !second.isEmpty()) {
            if (!first.isEmpty()) {
                cur.next = first.get(0);
                first.remove(0);
                cur = cur.next;
            }

            if (!second.isEmpty()) {
                cur.next = second.get(0);
                second.remove(0);
                cur = cur.next;
            }
        }
        cur.next = null;

        return head;
    }

    public static void main(String[] args) {
        var l = ListUtil.of(1,2,3,4);
        var solution = new _24_Swap_Nodes_in_Pairs();
        ListNode listNode = solution.swapPairs(l);
        ListUtil.print(listNode);
    }
}
