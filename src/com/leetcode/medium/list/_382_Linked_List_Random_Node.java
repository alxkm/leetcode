package com.leetcode.medium.list;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _382_Linked_List_Random_Node {
    //382. Linked List Random Node
    //https://leetcode.com/problems/linked-list-random-node/description/

    class Solution {
        private List<Integer> list = new ArrayList<>();
        private Random rnd = new Random();

        public Solution(ListNode head) {
            ListNode h = head;
            while (h != null) {
                list.add(h.val);
                h = h.next;
            }
        }

        public int getRandom() {
            return list.get(rnd.nextInt(list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}