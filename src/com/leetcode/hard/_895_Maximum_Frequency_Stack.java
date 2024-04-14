package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class _895_Maximum_Frequency_Stack {
    //895. Maximum Frequency Stack
    //https://leetcode.com/problems/maximum-frequency-stack/

    class FreqStack {
        Map<Integer, Integer> fr = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> fr.get(x) - fr.get(y));
        Map<Integer, Set<Integer>> order = new HashMap<Integer, Set<Integer>>();

        public FreqStack() {

        }

        public void push(int val) {
            stack.add(val);
            fr.put(val, fr.getOrDefault(val, 0) + 1);
            var sortedSet = order.getOrDefault(val, new TreeSet<>(Collections.reverseOrder()));
            sortedSet.add(stack.size() - 1);
            order.put(val, sortedSet);
            queue.offer(val);
        }

        public int pop() {
            int val = queue.poll();
            var index = order.get(val).iterator().next();
            stack.remove(index);
            fr.put(val, fr.get(val) - 1);
            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
