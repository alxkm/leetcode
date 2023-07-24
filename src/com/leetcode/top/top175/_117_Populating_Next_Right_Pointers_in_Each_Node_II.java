package com.leetcode.top.top175;

import com.leetcode.TreeUtil;
import com.leetcode.top.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    //NEED_TO_SOLVE

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (prev != null) prev.next = cur;
                prev = cur;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Integer[] a = {1,2,3,4,5,null,7};
        Node root = TreeUtil.formTreeNodeConnected(a);

        var solution = new _117_Populating_Next_Right_Pointers_in_Each_Node_II();
        solution.connect(root);
    }
}
