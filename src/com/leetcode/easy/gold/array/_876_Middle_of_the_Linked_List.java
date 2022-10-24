package com.leetcode.easy.gold.array;

import com.company.list.ListNode;

public class _876_Middle_of_the_Linked_List {
    static public ListNode middleNode(ListNode head) {
        ListNode l = head;
        int size = 0;
        while (l != null) {
            size++;
            l = l.next;
        }

        int middle = size % 2 == 0 ? (size / 2) + 1 : ((size - 1) / 2) + 1;

        int i = 0;
        l = head;
        while (l != null) {
            i++;
            if (i == middle) return l;
            l = l.next;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
