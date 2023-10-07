package com.leetcode.top.top175;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class _863_All_Nodes_Distance_K_in_Binary_Tree {
    //863. All Nodes Distance K in Binary Tree
    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    //todo todo todo
    //FOREIGN_SOLUTION
    //tree
    //dfs
    //bfs
    //TOP

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> l = new ArrayList<>();
//
//        dfs(target, k, l);
//        dfs1(root, target, new int[]{k}, new boolean[]{false}, l);
//        // Stack<TreeNode> s1 = new Stack<>();
//        // Stack<TreeNode> s2 = new Stack<>();
//        // s1.add(root);
//        // s2.add(root);
//        // while (!s1.isEmpty()) {
//        //     var node = s1.pop();
//        //     if (node == target) break;
//        //     if (node.left != null) {
//        //         s1.add(node.left);
//        //         s2.add(node.left);
//        //     }
//        //     if (node.right != null) {
//        //         s1.add(node.right);
//        //         s2.add(node.right);
//        //     }
//        // }
//        return l;
//    }
//
//    private void dfs(TreeNode t, int k, List<Integer> l) {
//        if (t == null) return;
//        if (k == 0) {
//            l.add(t.val);
//            return;
//        }
//        dfs(t.left, k - 1, l);
//        dfs(t.right, k - 1, l);
//    }
//
//    private void dfs1(TreeNode t, TreeNode target, int[] k, boolean[] reached, List<Integer> l) {
//        if (t == null) return;
//        if (k[0] < 0) return;
//        if (k[0] == 0) {
//            l.add(t.val);
//            return;
//        }
//        if (t == target) {
//            reached[0] = true;
//            return;
//        }
//        dfs1(t.left, target, k, reached, l);
//        if (reached[0]) k[0]--;
//        if (k[0] == 0) l.add(t.val);
//
//        dfs1(t.right, target, k, reached, l);
//        if (reached[0]) k[0]--;
//        if (k[0] == 0) l.add(t.val);
//    }

//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> l = new ArrayList<>();
//        Map<TreeNode, TreeNode> map = new HashMap<>();
//        //dfs(target, k, l);
//        //dfs(root, map);
//
//        if (target != root) {
//            TreeNode t = map.get(target);
//            k--;
//            if (k == 0) {
//                l.add(t.val);
//            } else {
//                while (k >= 0) {
//                    var t1 = map.get(t);
//                    if (t1 == null && t == root) {
//                }
//            }
//
//        }
//
//        return l;
//    }

//    private void dfs(TreeNode t, int k, List<Integer> l) {
//        if (t == null) return;
//        if (k == 0) {
//            l.add(t.val);
//            return;
//        }
//        dfs(t.left, k - 1, l);
//        dfs(t.right, k - 1, l);
//    }
//
//    private void dfs(TreeNode t, Map<TreeNode, TreeNode> map) {
//        if (t == null) return;
//
//        if (t.left != null) {
//            map.put(t.left, t);
//            dfs(t.left, map);
//        }
//        if (t.right != null) {
//            map.put(t.right, t);
//            dfs(t.right, map);
//        }
//    }
//
//    public static void main(String[] args) {
//        //3,5,1,6,2,0,8,null,null,7,4
//        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
//        TreeNode treeNode = new TreeNode(3,
//                target,
//                new TreeNode(1, new TreeNode(7), new TreeNode(4))
//        );
//        _863_All_Nodes_Distance_K_in_Binary_Tree solution = new _863_All_Nodes_Distance_K_in_Binary_Tree();
//
//        System.out.println(solution.distanceK(treeNode, target, 2));
//    }

    Stack<TreeNode> parentsStack = new Stack<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> l = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        dfs(root, target);
        while (!parentsStack.isEmpty() && k >= 0) {
            TreeNode cur = parentsStack.pop();
            visit.add(cur.val);
            List<Integer> currChildren = traverseChildrens(cur, k, visit);
            l.addAll(currChildren);
            k--;
        }
        return l;
    }

    public List<Integer> traverseChildrens(TreeNode parent, int k, Set<Integer> seen) {
        Queue<TreeNode> parentsQueue = new LinkedList<>();
        Queue<TreeNode> childrenQueue = new LinkedList<>();
        List<Integer> levelNodes = new ArrayList<>();
        int level = 0;
        parentsQueue.add(parent);

        while (!parentsQueue.isEmpty()){
            TreeNode head = parentsQueue.remove();
            levelNodes.add(head.val);
            if (head.left != null && !seen.contains(head.left.val)) {
                childrenQueue.add(head.left);
            }
            if (head.right != null && !seen.contains(head.right.val)) {
                childrenQueue.add(head.right);
            }

            if (parentsQueue.isEmpty()) {
                if (level == k) {
                    return levelNodes;
                }
                else {
                    levelNodes = new ArrayList<>();
                    parentsQueue = childrenQueue;
                    childrenQueue = new LinkedList<TreeNode>();
                    level++;
                }
            }
        }
        return new ArrayList<>();
    }

    private void dfs(TreeNode t, int k, List<Integer> l) {
        if (t == null) return;
        if (k == 0) {
            l.add(t.val);
            return;
        }
        dfs(t.left, k - 1, l);
        dfs(t.right, k - 1, l);
    }


    private boolean dfs(TreeNode t, TreeNode target) {
        if (t == null) return false;
        if (t == target) {
            parentsStack.push(t);
            return true;
        }
        parentsStack.push(t);
        if (dfs(t.left, target)) {
            return true;
        }
        parentsStack.pop();
        parentsStack.push(t);

        if (dfs(t.right, target)) {
            return true;
        }
        parentsStack.pop();
        return false;
    }
}
