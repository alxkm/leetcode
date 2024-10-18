package com.leetcode.medium.brackets;

import java.util.Stack;

public class _1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced {
    //1963. Minimum Number of Swaps to Make the String Balanced
    //https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
    //todo todo todo
    //foreign_solution

    public int minSwaps(String s) {
        int swap = 0;
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    swap++;
                }
            }
        }
        return (swap + 1) / 2;
    }
}
