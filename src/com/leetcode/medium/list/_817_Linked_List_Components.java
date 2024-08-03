package com.leetcode.medium.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.HashSet;
import java.util.Set;

public class _817_Linked_List_Components {
    //817. Linked List Components
    //https://leetcode.com/problems/linked-list-components/

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        ListNode h = head;
        int counter = 0;

        while (h != null) {
            if (set.contains(h.val)) {
                while (h != null && set.remove(h.val)) {
                    h = h.next;
                }
                counter++;
            }
            if (h != null) h = h.next;
        }

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _817_Linked_List_Components();
        sol.numComponents(ListUtil.of(0,1,2,3), new int[] {0,1,3});
        //sol.numComponents(ListUtil.build(List.of(1,2,0,4,3)), new int[] {3,4,0,2,1});
    }
}
