package com.leetcode.medium.stack;

public class _1381_Design_a_Stack_With_Increment_Operation {
    //https://leetcode.com/problems/design-a-stack-with-increment-operation/

    class CustomStack {
        private int[] st;
        private int cur = -1;

        public CustomStack(int maxSize) {
            st = new int[maxSize];
        }

        public void push(int x) {
            if (cur == st.length - 1) return;
            st[++cur] = x;
        }

        public int pop() {
            if (cur == -1) return -1;
            int val = st[cur--];
            st[cur + 1] = 0;
            return val;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i <= cur; i++) {
                st[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}