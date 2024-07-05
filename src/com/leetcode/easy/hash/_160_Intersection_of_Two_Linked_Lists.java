package com.leetcode.easy.hash;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.HashSet;

public class _160_Intersection_of_Two_Linked_Lists {
    //https://leetcode.com/problems/intersection-of-two-linked-lists/

    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var s = new HashSet<ListNode>();
        if (headA == headB) return headA;
        while (headA != null) {
            s.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (s.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode build = ListUtil.of(1, 4, 6);
        ListNode build1 = ListUtil.of(1, 5);
    }
}
