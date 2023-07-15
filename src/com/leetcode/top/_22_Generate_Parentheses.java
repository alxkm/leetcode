package com.leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    //https://leetcode.com/problems/generate-parentheses/

    public void f(int op, int cl, int n, StringBuilder sb, List<String> l) {
        if (op == n && cl == n) {
            l.add(sb.toString());
            return;
        }
        if (op < n) {
            sb.append("(");
            f(op + 1, cl, n, sb, l);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (op > cl) {
            sb.append(")");
            f(op, cl + 1, n, sb, l);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        var sb = new StringBuilder();
        sb.append("(");
        f(1, 0, n, sb, l);
        return l;
    }
}
