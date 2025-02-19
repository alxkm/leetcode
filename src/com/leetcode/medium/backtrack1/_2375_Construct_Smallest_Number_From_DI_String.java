package com.leetcode.medium.backtrack1;

import java.util.Stack;

public class _2375_Construct_Smallest_Number_From_DI_String {
    //2375. Construct Smallest Number From DI String
    //https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
    //stack

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < pattern.length() + 1; i++) {
            st.push(i + 1);

            while (!st.isEmpty() && (i == pattern.length() || pattern.charAt(i) == 'I')) {
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}
