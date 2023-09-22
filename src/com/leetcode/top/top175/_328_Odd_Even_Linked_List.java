package com.leetcode.top.top175;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.List;

public class _328_Odd_Even_Linked_List {
    //328. Odd Even Linked List
    //https://leetcode.com/problems/odd-even-linked-list/
    //FOREIGN_SOLUTION
    //TOP

    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head, odd = null, oddHead = null, even = null;
        int i = 1;
        while (cur != null) {
            if (i % 2 == 0) {
                if (oddHead == null) {
                    oddHead = cur;
                    odd = cur;
                } else {
                    odd.next = cur;
                    odd = odd.next;
                }
            } else {
                if (even == null) {
                    even = cur;
                } else {
                    even.next = cur;
                    even = even.next;
                }

            }
            cur = cur.next;
            i++;
        }
        odd.next = null;
        even.next = oddHead;
        return head;
    }

    public static void main(String[] args) {
        var l = ListUtil.build(List.of(1,2,3,4,5));
        var solution = new _328_Odd_Even_Linked_List();
        ListUtil.print(solution.oddEvenList(l));
    }
}
