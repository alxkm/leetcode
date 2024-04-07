package com.leetcode.medium.list;

public class _430_Flatten_a_Multilevel_Doubly_Linked_List {
    //https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    //430. Flatten a Multilevel Doubly Linked List

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    };

    public Node flatten(Node head) {
        if (head == null) return null;

        dfs(head.next, head);
        return head;
    }

    private void dfs(Node cur, Node prev) {
        if (cur == null) return;
        cur.prev = prev;
        var curNext = cur.next;
        if (cur.child != null) {
            cur.next = cur.child;
            dfs(cur.next, cur);
        }
        cur.next = curNext;
        dfs(cur.next, cur);
    }

    public static void main(String[] args) {
        var solution = new _430_Flatten_a_Multilevel_Doubly_Linked_List();
        Node _1 = new Node(1, null);
        Node _2 = new Node(2, null);
        Node _3 = new Node(3, null);
        Node _4 = new Node(4, null);
        Node _5 = new Node(5, null);
        Node _6 = new Node(6, null);
        Node _7 = new Node(7, null);
        Node _8 = new Node(8, null);
        Node _9 = new Node(9, null);
        Node _10 = new Node(10, null);
        Node _11 = new Node(11, null);
        Node _12 = new Node(12, null);


        _1.next = _2;
        _2.prev = _1;
        _2.next = _3;
        _3.prev = _2;
        _3.next = _4;
        _4.next = _5;
        _4.prev = _3;
        _5.next = _6;
        _6.prev = _5;
        _3.child = _7;
        _7.next = _8;
        _8.prev = _7;
        _8.next = _9;
        _9.prev = _8;
        _9.next = _10;
        _10.prev = _9;

        _8.child = _11;
        _11.next = _12;
        _12.prev = _11;


        System.out.println(solution.flatten(_1));
    }
}
