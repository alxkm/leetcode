package com.leetcode.top.top175;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class _662_Maximum_Width_of_Binary_Tree {
    //https://leetcode.com/problems/maximum-width-of-binary-tree/
    //FOREIGN_SOLUTION
    //TOP

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Optional<TreeNode>> q = new PriorityQueue<>((t1, t2) -> {
            if (t1.isPresent()) return -1;
            return 1;
        });
        q.add(Optional.ofNullable(root));
        int size = 1;
        while (!q.isEmpty()) {
            if (q.peek().isEmpty()) return size;
            size = Math.max(q.size(), size);
            int curSize = q.size();
            List<Optional<TreeNode>> temp = new ArrayList<>();
            while (curSize > 0) {
                Optional<TreeNode> t = q.poll();
                if (t.isEmpty()) {
                    temp.add(Optional.empty());
                    temp.add(Optional.empty());
                } else {
                    temp.add(Optional.ofNullable(t.get().left));
                    temp.add(Optional.ofNullable(t.get().right));
                }
                curSize--;
            }
            q.addAll(temp);
        }
        return size;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.formTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
        var solution = new _662_Maximum_Width_of_Binary_Tree();
        System.out.println(solution.widthOfBinaryTree(treeNode));
    }
}
