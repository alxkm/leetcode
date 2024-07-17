package com.leetcode.medium.tree;

import com.leetcode.ArrayUtil;
import com.leetcode.Pair;
import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1110_Delete_Nodes_And_Return_Forest1 {
    //https://leetcode.com/problems/delete-nodes-and-return-forest/description/?envType=daily-question&envId=2024-07-17
    //1110. Delete Nodes And Return Forest
    //TOP

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Arrays.sort(to_delete);
        Map<Integer, Pair<TreeNode, TreeNode>> map = new HashMap<>();
        dfs(root, null, map);
        System.out.println(map.size());
        List<TreeNode> l = new ArrayList<>();
        for (int i = to_delete.length - 1; i >= 0; i--) {
            int x = to_delete[i];

            if (root.val == x) root = null;

            var pair = map.get(x);

            TreeNode curNode = pair.getKey();
            TreeNode parentNode = pair.getValue();

            if (curNode.left != null) l.add(curNode.left);
            if (curNode.right != null) l.add(curNode.right);
            map.remove(x);
            if (parentNode == null) continue;
            if (parentNode.left != null && parentNode.left.val == x) parentNode.left = null;
            if (parentNode.right != null && parentNode.right.val == x) parentNode.right = null;
        }
        if (root != null) l.add(root);
        return l;
    }

    public void dfs(TreeNode t, TreeNode p, Map<Integer, Pair<TreeNode, TreeNode>> map) {
        if (t == null) return;
        map.put(t.val, new Pair<>(t, p));
        dfs(t.left, t, map);
        dfs(t.right, t, map);
    }

    public static void main(String[] args) {
        var sol = new _1110_Delete_Nodes_And_Return_Forest1();
        System.out.println(sol.delNodes(TreeUtil.formTree(ArrayUtil.ofInteger(1, 2, 3, null, null, null, 4)), ArrayUtil.of(2, 1)));
    }
}
