package com.leetcode.easy.hash;

import com.leetcode.easy.list.ListNode;
import com.leetcode.easy.list.ListUtil;

import java.util.HashSet;
import java.util.List;

public class _160_Intersection_of_Two_Linked_Lists {
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
        ListNode build = ListUtil.build(List.of(1, 4, 6));
        ListNode build1 = ListUtil.build(List.of(1, 5));


    }
}
