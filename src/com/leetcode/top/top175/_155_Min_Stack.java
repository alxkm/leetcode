package com.leetcode.top.top175;

import java.util.Stack;

public class _155_Min_Stack {
    //https://leetcode.com/problems/min-stack/
    //FOREIGN_SOLUTION

    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

//    public void push1(int val) {
//        if (min >= val) {
//            stack.push(min);
//            min = val;
//        }
//        stack.push(val);
//    }
//
//    public void pop1() {
//        var x = stack.pop();
//        if (x == min) min = stack.pop();
//    }

    public void push(int val) {
        if (!stack.isEmpty()) {
            stack.add(min);
            stack.add(val);
            min = Math.min(min, val);
        } else {
            stack.add(val);
            min = val;
        }
    }

    public void pop() {
        stack.pop();
        if (!stack.isEmpty()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        var st = new _155_Min_Stack();
        st.push(2147483646);
        st.push(2147483646);
        st.push(2147483647);
        st.top();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.push(2147483647);
        st.top();

        st.getMin();
        st.push(-2147483648);
        st.top();
        st.getMin();
        st.pop();
        st.getMin();
    }

    /*

    ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]


out
[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
exp
[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
     */
}
