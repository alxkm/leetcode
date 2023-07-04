package com.leetcode.medium.list;

import java.util.HashMap;
import java.util.Map;

public class _138_Copy_List_with_Random_Pointer {
    //https://leetcode.com/problems/copy-list-with-random-pointer/
    //todo todo

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Integer, Node> randomMap = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();
        Map<Node, Integer> hashMap = new HashMap<>();

        Node copy = new Node(0);
        Node copyOfCopy = copy;
        int i = 1;
        while (head != null) {
            copy.next = new Node(head.val);
            copy = copy.next;
            newMap.put(i, copy);
            randomMap.put(i, head.random);
            hashMap.put(head, i);
            i++;
            head = head.next;
        }
        for (var entry: newMap.entrySet()) {
            var random = randomMap.get(entry.getKey());
            if (random != null) {
                entry.getValue().random = newMap.get(hashMap.get(random));
                //System.out.println(entry.getValue().val);
                //System.out.println(random.val);
                //System.out.println( newMap.get(random.val).val);
                //System.out.println();
            }
        }
        return copyOfCopy.next;
    }
}
