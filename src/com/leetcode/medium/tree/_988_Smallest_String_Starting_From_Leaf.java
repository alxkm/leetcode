package com.leetcode.medium.tree;

import com.leetcode.ArrayUtil;
import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.Comparator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class _988_Smallest_String_Starting_From_Leaf {
    //988. Smallest String Starting From Leaf
    //https://leetcode.com/problems/smallest-string-starting-from-leaf/

    public String smallestFromLeaf(TreeNode root) {
        Set<String> set = new TreeSet<>();
        dfs(root, set, new Stack<>());
        return set.iterator().next();
    }

    private void dfs(TreeNode t, Set<String> set, Stack<Integer> st) {
        if (t == null) return;

        st.add(t.val);
        if (t.left == null && t.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int ch: st) sb.append((char)(ch + 'a'));
            sb.reverse();
            set.add(sb.toString());
        } else {
            dfs(t.left, set, st);
            dfs(t.right, set, st);
        }
        st.pop();
    }

    public static void main(String[] args) {
        var sol = new _988_Smallest_String_Starting_From_Leaf();
        System.out.println(sol.smallestFromLeaf(TreeUtil.formTree(ArrayUtil.ofInteger(0, null, 1))));
    }
}
