package com.leetcode.easy.list;

import com.leetcode.ListNode;

public class _2_Add_Two_Numbers {
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
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode f = l1;
            ListNode s = l2;
            ListNode r = new ListNode(0);
            ListNode r1 = r;
            int rm = 0;
            boolean init = true;

            while ((f != null || s != null) || rm != 0) {

                int v = 0;
                if (f != null) {
                    v += f.val;
                    f = f.next;
                }
                if (s != null) {
                    v += s.val;
                    s = s.next;
                }
                v += rm;
                rm = 0;

                if (v / 10 != 0) {
                    rm = v / 10;
                    v = v % 10;
                }

                if (init) {
                    r.val = v;
                    init = false;
                } else {
                    r.next = new ListNode(v);
                    r = r.next;
                    r.val = v;
                }
            }
            return r1;
        }
    }
}
