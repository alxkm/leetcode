package com.leetcode.medium.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    //https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    //1171. Remove Zero Sum Consecutive Nodes from Linked List

    public ListNode removeZeroSumSublists(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h);
        }
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int i = 0; i < list.size(); i++) {
                int s = list.get(i).val;
                for (int j = i + 1; j < list.size(); j++) {
                    s += list.get(j).val;
                    if (s == 0) {
                        updated = true;
                        for (int k = j; k >= i; k--) list.remove(k);
                        break;
                    }
                }
                if (updated) break;
            }
        }

        if (list.size() == 0) return null;

        list.get(list.size() - 1).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        return list.get(0);
    }


    public static ListNode removeZeroSumSublists1(ListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, ListNode> hm = new HashMap<>();
        ListNode temp = head;
        int sum = 0;

        while (temp != null) {
            sum += temp.val;

            if (sum == 0) {
                head = temp.next;
                temp = temp.next;
            } else if (hm.containsKey(sum)) {
                ListNode ans = hm.get(sum);
                ans.next = temp.next;
                hm=new HashMap<>();
                temp=head;
                sum=0;
            } else {
                hm.put(sum, temp);
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        var l = ListUtil.build(List.of(5,-3,-4,1,6,-2,-5));
        ListUtil.print(removeZeroSumSublists1(l));
    }
}
