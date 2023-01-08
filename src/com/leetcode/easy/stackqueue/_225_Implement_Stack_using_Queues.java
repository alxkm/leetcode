package com.leetcode.easy.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class _225_Implement_Stack_using_Queues {
    class MyStack {
        private final Queue<Integer> q1;
        private final Queue<Integer> q2;

        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            if (q1.isEmpty()) return true;
            return false;
        }
    }
}
