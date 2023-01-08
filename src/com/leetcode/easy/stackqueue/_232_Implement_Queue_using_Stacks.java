package com.leetcode.easy.stackqueue;

import java.util.Stack;

public class _232_Implement_Queue_using_Stacks {
    class MyQueue {
        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            int n = pop();
            stack2.push(n);
            return n;
        }

        public boolean empty() {
            if (stack1.isEmpty() && stack2.isEmpty()) return true;
            return false;
        }
    }
}
