package com.leetcode.easy.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

public class _21_Merge_Two_Sorted_Lists {
    //21. Merge Two Sorted Lists
    //https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null) return list2;

        ListNode head;
        ListNode h = new ListNode();
        head = h;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                h.next = new ListNode(list2.val);
                h = h.next;
                list2 = list2.next;
            } else {
                h.next = new ListNode(list1.val);
                h = h.next;
                list1 = list1.next;
            }
        }
        h.next = list1 != null ? list1 : list2;
        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list2 == null && list1 != null) return list1;
        if (list1 == null && list2 != null) return list2;

        ListNode head = new ListNode();
        ListNode newHead = head;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else if (list1.val > list2.val) {
                    head.next = list2;
                    list2 = list2.next;
                } else {
                    head.next = list1;
                    list1 = list1.next;
                    head = head.next;
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            } else {
                while (list1 != null) {
                    head.next = list1;
                    list1 = list1.next;
                    head = head.next;
                }
                while (list2 != null) {
                    head.next = list2;
                    list2 = list2.next;
                    head = head.next;
                }
            }
        }

        return newHead.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode h = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                var t = h1.next;
                h.next = h1;
                h = h.next;
                h.next = null;
                h1 = t;
            } else if (h1.val > h2.val) {
                var t = h2.next;
                h.next = h2;
                h = h.next;
                h.next = null;
                h2 = t;
            } else {
                var t1 = h1.next;
                var t2 = h2.next;
                h.next = h1;
                h = h.next;
                h.next = null;
                h.next = h2;
                h = h.next;
                h.next = null;
                h1 = t1;
                h2 = t2;
            }
        }

        while (h1 != null) {
            h.next = h1;
            h1 = h1.next;
        }
        while (h2 != null) {
            h.next = h2;
            h2 = h2.next;
        }
        return h.next;
    }


    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode h = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                var t = h1.next;
                h.next = h1;
                h = h.next;
                h.next = null;
                h1 = t;
            } else if (h1.val > h2.val) {
                var t = h2.next;
                h.next = h2;
                h = h.next;
                h.next = null;
                h2 = t;
            } else {
                var t1 = h1.next;
                var t2 = h2.next;
                h.next = h1;
                h = h.next;
                h.next = null;
                h.next = h2;
                h = h.next;
                h.next = null;
                h1 = t1;
                h2 = t2;
            }
        }
        while (h1 != null) {
            h.next = h1;
            h1 = h1.next;
        }
        while (h2 != null) {
            h.next = h2;
            h2 = h2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists2(ListUtil.of(1, 2, 4), ListUtil.of(1, 3, 4)));
    }
}
