package com.company.list;

public class MergeTwoLists {
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
                list2 = list2.next;
            } else {
                h.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            h = h.next;
        }
        h.next = list1 != null ? list1 : list2;
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoLists o = new MergeTwoLists();
        //o.mergeTwoLists()
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3,  new ListNode(4))));
        ListNode x = o.mergeTwoLists(l1, l2);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
