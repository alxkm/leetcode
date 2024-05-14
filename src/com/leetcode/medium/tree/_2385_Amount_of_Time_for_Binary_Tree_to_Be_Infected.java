package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    //https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
    //2385. Amount of Time for Binary Tree to Be Infected

    Map<Integer, List<Integer>> map = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        dfs(root);
        Set<Integer> visit = new HashSet<>();
        int counter = 0;
        Queue<Integer> q = new LinkedList<>();
        var l = map.get(start);
        if (l == null) return 0;
        q.addAll(l);
        visit.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int v = q.poll();
                visit.add(v);
                for (int t: map.get(v)) {
                    if (!visit.contains(t)) {
                        q.offer(t);
                    }
                }
            }
            counter++;
        }

        return counter;
    }

    private void dfs(TreeNode t) {
        if (t == null) return;
        int curVal = t.val;

        if (t.right != null) {
            int r = t.right.val;

            if (map.get(curVal) == null) map.put(curVal, new ArrayList<>());
            map.get(curVal).add(r);

            if (map.get(r) == null) map.put(r, new ArrayList<>());
            map.get(r).add(curVal);
        }

        if (t.left != null) {
            int l = t.left.val;

            if (map.get(curVal) == null) map.put(curVal, new ArrayList<>());
            map.get(curVal).add(l);

            if (map.get(l) == null) map.put(l, new ArrayList<>());
            map.get(l).add(curVal);
        }
        dfs(t.left);
        dfs(t.right);
    }
}
