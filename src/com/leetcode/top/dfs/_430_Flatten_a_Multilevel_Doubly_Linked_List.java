package com.leetcode.top.dfs;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class _430_Flatten_a_Multilevel_Doubly_Linked_List {
    //https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    //TOP

    public Node flatten(Node head) {
        if (head == null) return null;

        Node newHead = new Node();
        newHead.next = head;

        dfs(head, newHead);
        newHead.next.prev = null;
        return newHead.next;
    }

    private void dfs(Node cur, Node prev) {
        if (cur == null) {
            //System.out.println("RETURN");
            return;
        }
        //System.out.println(cur.val);
        cur.prev = prev;
        var oldNext = cur.next;

        if (cur.child != null) {
            var child = cur.child;
            cur.child = null;
            cur.next = child;

            dfs(child, cur);

            Node newCur = cur.next;
            while (newCur.next != null) {
                newCur = newCur.next;
            }
            cur = newCur;
        }
        cur.next = oldNext;
        dfs(cur.next, cur);
    }
}
