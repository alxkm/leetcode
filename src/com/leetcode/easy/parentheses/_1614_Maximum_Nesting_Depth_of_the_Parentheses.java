package com.leetcode.easy.parentheses;

public class _1614_Maximum_Nesting_Depth_of_the_Parentheses {
    //1614. Maximum Nesting Depth of the Parentheses
    //https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

    public int maxDepth(String s) {
        int op = 0, max = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                op++;
                max = Math.max(max, op);
            }
            else if (ch == ')') op--;
            else if (ch >= '0' && ch <= '9') max = Math.max(max, op);
        }

        return max;
    }
}
