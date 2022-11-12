package com.leetcode.easy.math;

import java.util.Stack;
import com.leetcode.easy.list.ListNode;

public class _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {
    public int getDecimalValue(ListNode head) {
        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        int n = 0;
        int i = 0;
        while (!st.isEmpty()) {
            n += (st.pop() * Math.pow(2, i++));
        }
        return n;
    }
}
