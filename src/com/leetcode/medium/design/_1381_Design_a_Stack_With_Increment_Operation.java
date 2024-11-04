package com.leetcode.medium.design;

public class _1381_Design_a_Stack_With_Increment_Operation {
    //https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
    //1381. Design a Stack With Increment Operation

    class CustomStack0 {
        private int[] st;
        private int cur = -1;

        public CustomStack0(int maxSize) {
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

    public static class CustomStack {

        int[] ar;
        int size = 0;
        int maxSize = 0;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            ar = new int[maxSize];
        }

        public void push(int x) {
            if (size >= maxSize) return;
            ar[size++] = x;
        }

        public int pop() {
            if (size <= 0) return -1;
            return ar[--size];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i < size; i++) {
                ar[i] += val;
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

    public static void main(String[] args) {
        var s = new CustomStack(3);
        s.push(1);
        s.push(2);
        s.pop();
        s.push(2);
        s.push(3);
        s.push(4);
        s.increment(5, 100);
        s.increment(2, 100);
        s.pop();
    }
}
