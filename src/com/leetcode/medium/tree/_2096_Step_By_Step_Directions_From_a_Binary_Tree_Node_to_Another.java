package com.leetcode.medium.tree;

import com.leetcode.Pair;
import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class _2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another {
    //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/?envType=daily-question&envId=2024-07-16
    //2096. Step-By-Step Directions From a Binary Tree Node to Another
//
//    public String getDirections(TreeNode root, int startValue, int destValue) {
//        TreeNode t = dfsFind(root, s, new Stack<>());
//
//        Stack<Character> st = dfsFindBottom(t, new Stack<>(), e);
//
//        if (st == null) {
//            TreeNode t = dfsFind(root, e, new Stack<>());
//            Stack<Character> st = dfsFindBottom(t, new Stack<>(), e);
//
//            st = dfsFindUp(t, new Stack<>());
//            if (root.val == e) {
//
//            }
//            if (st == null) return "";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < st.size(); i++) sb.append(st.get(i));
//        return sb.toString();
//    }
//
//    private TreeNode dfsFind(TreeNode t, int n, Stack<Character> st) {
//        if (t == null) return null;
//        if (t.val == n) return t;
//        var l = dfsFind(t.left, n);
//        if (l != null) return l;
//        var r = dfsFind(t.right, n);
//        if (r != null) return r;
//        return null;
//    }
//
//    private Stack<Character> dfsFindBottom(TreeNode t, Stack<Character> st, int e) {
//        if (t == null) return null;
//        if (t.val == e) return st;
//        st.push('L');
//        var l = dfsFindBottom(t.left, st, e);
//        if (l != null) return l;
//        st.pop();
//        st.push('R');
//        var r = dfsFindBottom(t.right, st, e);
//        if (r != null) return r;
//        return null;
//    }
//
//    private Stack<Character> dfsFindUp(TreeNode t, Stack<Character> st) {
//        if (t == null) return null;
//        if (t.val == s) return new Stack<>();
//        // st.push("L");
//        // var l = dfsFind(t.left, st, e);
//        // if (l != null) return st;
//        // st.pop();
//        // st.push("R");
//        // var r = dfsFind(t.right);
//        // if (r != null) return st;
//        return null;
//    }

        public String getDirections(TreeNode root, int startValue, int destValue) {
                // Map to store parent nodes
                Map<Integer, TreeNode> parentMap = new HashMap<>();

                // Find the start node and populate parent map
                TreeNode startNode = findStartNode(root, startValue);
                populateParentMap(root, parentMap);

                // Perform BFS to find the path
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(startNode);
                Set<TreeNode> visitedNodes = new HashSet<>();
                // Key: next node, Value: <current node, direction>
                Map<TreeNode, Pair<TreeNode, String>> pathTracker = new HashMap<>();
                visitedNodes.add(startNode);

                while (!queue.isEmpty()) {
                        TreeNode currentNode = queue.poll();

                        // If destination is reached, return the path
                        if (currentNode.val == destValue) {
                                return backtrackPath(currentNode, pathTracker);
                        }

                        // Check and add parent node
                        if (parentMap.containsKey(currentNode.val)) {
                                TreeNode parentNode = parentMap.get(currentNode.val);
                                if (!visitedNodes.contains(parentNode)) {
                                        queue.add(parentNode);
                                        pathTracker.put(parentNode, new Pair(currentNode, "U"));
                                        visitedNodes.add(parentNode);
                                }
                        }

                        // Check and add left child
                        if (
                                currentNode.left != null &&
                                        !visitedNodes.contains(currentNode.left)
                        ) {
                                queue.add(currentNode.left);
                                pathTracker.put(currentNode.left, new Pair(currentNode, "L"));
                                visitedNodes.add(currentNode.left);
                        }

                        // Check and add right child
                        if (
                                currentNode.right != null &&
                                        !visitedNodes.contains(currentNode.right)
                        ) {
                                queue.add(currentNode.right);
                                pathTracker.put(currentNode.right, new Pair(currentNode, "R"));
                                visitedNodes.add(currentNode.right);
                        }
                }

                // This line should never be reached if the tree is valid
                return "";
        }

        private String backtrackPath(
                TreeNode node,
                Map<TreeNode, Pair<TreeNode, String>> pathTracker
        ) {
                StringBuilder path = new StringBuilder();

                // Construct the path
                while (pathTracker.containsKey(node)) {
                        // Add the directions in reverse order and move on to the previous node
                        path.append(pathTracker.get(node).getValue());
                        node = pathTracker.get(node).getKey();
                }

                // Reverse the path
                path.reverse();

                return path.toString();
        }

        private void populateParentMap(
                TreeNode node,
                Map<Integer, TreeNode> parentMap
        ) {
                if (node == null) return;

                // Add children to the map and recurse further
                if (node.left != null) {
                        parentMap.put(node.left.val, node);
                        populateParentMap(node.left, parentMap);
                }

                if (node.right != null) {
                        parentMap.put(node.right.val, node);
                        populateParentMap(node.right, parentMap);
                }
        }

        private TreeNode findStartNode(TreeNode node, int startValue) {
                if (node == null) return null;

                if (node.val == startValue) return node;

                TreeNode leftResult = findStartNode(node.left, startValue);

                // If left subtree returns a node, it must be StartNode. Return it
                // Otherwise, return whatever is returned by right subtree.
                if (leftResult != null) return leftResult;
                return findStartNode(node.right, startValue);
        }
}
