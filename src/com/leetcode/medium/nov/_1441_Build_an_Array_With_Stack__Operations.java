package com.leetcode.medium.nov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _1441_Build_an_Array_With_Stack__Operations {
    //https://leetcode.com/problems/build-an-array-with-stack-operations/
    //1441. Build an Array With Stack Operations

    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> st = new Stack<>();
        List<String> actions = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num: target)set.add(num);

        for (int i = 1; i <= n; i++) {
            st.push(i);
            actions.add("Push");
            if (!set.contains(i)) {
                st.pop();
                actions.add("Pop");
            }
            if (st.size() == target.length) return actions;
        }

        return actions;
    }
}
