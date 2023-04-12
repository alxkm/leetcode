package com.leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133_Clone_Graph {
    //https://leetcode.com/problems/clone-graph/
    //133. Clone Graph

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return clone(node, new HashMap<>());
    }

    Node clone(Node n, Map<Node, Node> used) {
        if (used.get(n) != null) return used.get(n);
        var copy = new Node(n.val);
        used.put(n, copy);

        for (Node node: n.neighbors) {
            copy.neighbors.add(clone(node, used));
        }
        return copy;
    }
}
