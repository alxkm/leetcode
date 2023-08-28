package com.leetcode.top;

import java.util.Stack;

public class _232_Implement_Queue_using_Stacks {
    //https://leetcode.com/problems/implement-queue-using-stacks/
    //FOREIGN_SOLUTION

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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
