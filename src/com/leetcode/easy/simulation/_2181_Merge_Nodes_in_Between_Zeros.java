package com.leetcode.easy.simulation;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class _2181_Merge_Nodes_in_Between_Zeros {
    //2181. Merge Nodes in Between Zeros
    //https://leetcode.com/problems/merge-nodes-in-between-zeros/?envType=daily-question&envId=2024-07-04

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

    public ListNode mergeNodes1(ListNode head) {
        ListNode cur = head;
        ListNode h = null;
        ListNode newNode = null;
        while (cur != null) {
            int sum = 0;
            cur = cur.next;
            while (cur != null && cur.val != 0) {
                sum += cur.val;
                cur = cur.next;
            }
            if (h == null && sum != 0) {
                h = new ListNode(sum);
                newNode = h;
            } else if (sum != 0) {
                h.next = new ListNode(sum);
                h = h.next;
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        var sol = new _2181_Merge_Nodes_in_Between_Zeros();
        sol.mergeNodes1(ListUtil.build(List.of(0,3,1,0,4,5,2,0)));
    }
}
