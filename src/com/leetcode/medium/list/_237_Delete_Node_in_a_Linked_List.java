package com.leetcode.medium.list;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _237_Delete_Node_in_a_Linked_List {
    //https://leetcode.com/problems/delete-node-in-a-linked-list/

    public void deleteNode(ListNode node) {
        if (node == null) return;
        List<ListNode> list = new ArrayList<>();
        var node1 = node;
        while (node1 != null) {
            list.add(node1);
            node1 = node1.next;
        }
        //int i = 1;
        // while (node != null) {
        //     node.val = list.get(i).val;
        //     i++;
        //     node = node.next;
        // }
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).val = list.get(i).val;
        }
        list.get(list.size() - 2).next = null;
    }
}
