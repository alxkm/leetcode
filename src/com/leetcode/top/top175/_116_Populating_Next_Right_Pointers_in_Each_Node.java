package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _116_Populating_Next_Right_Pointers_in_Each_Node {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    //todo todo

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;


        public Node() {}

        public Node(int _val) {
            val = _val;
        }


        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        List<Node> line = new LinkedList<>();
        line.add(root);
        while (!line.isEmpty()) {


            Node prev = line.get(line.size() - 1);
            for (int i = line.size() - 2; i >= 0; i--) {
                line.get(i).next = prev;
                prev = line.get(i);
            }

            line = getNextLayer(line);
            System.out.println("Line size = " + line.isEmpty());
            if (line.isEmpty()) {
                System.out.println("Should break = " + line.isEmpty());
                return root;
            }
        }
        return root;
    }


    private List<Node> getNextLayer(List<Node> prev) {
        List<Node> next = new ArrayList<>();
        System.out.println("BEFORE");
        System.out.println(prev.size());
        System.out.println(prev.get(0).val);
        for (Node node : prev) {

            if (node.left != null && node.right != null) {
                next.add(node.left);
                next.add(node.right);
            }
        }
        System.out.println("AFTER");
        System.out.println(next.size());


        return next;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        var l1 = new Node(4);
        var l2 = new Node(5);
        var r1 = new Node(6);
        var r2 = new Node(7);

        n.left.left = l1;
        n.left.right = l2;

        n.right.left = r1;
        n.right.right = r2;

        var solution = new _116_Populating_Next_Right_Pointers_in_Each_Node();
        solution.connect(n);
    }

}
