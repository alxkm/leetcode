package com.leetcode.medium.stack;

import java.util.Stack;

public class _946_Validate_Stack_Sequences {
    //https://leetcode.com/problems/validate-stack-sequences/

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed == null && popped == null) return true;
        Stack<Integer> st = new Stack<>();
        Integer prev = null;
        for (int i = 0, j = 0; i < pushed.length || j < popped.length;) {
            if (prev != null && popped[j] == prev) {
                st.pop();
                j++;
                if (!st.isEmpty()) {
                    prev = st.pop();
                    st.push(prev);
                } else {
                    prev = null;
                }
                continue;
            } else if (i < pushed.length) {
                prev = pushed[i];
                st.push(prev);
                i++;
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
