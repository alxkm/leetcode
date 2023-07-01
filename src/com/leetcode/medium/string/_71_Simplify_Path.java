package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _71_Simplify_Path {
    //https://leetcode.com/problems/simplify-path/

    public String simplifyPath(String path) {
        Stack<String> st = new Stack();
        String[] strs = path.split("/");
        for (String str: strs) {
            if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (str.equals(".") || str.equals("")) {
                continue;
            } else {
                st.push(str);
            }
        }
        List<String> list = new ArrayList(st);
        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
