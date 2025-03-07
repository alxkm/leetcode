package com.leetcode.medium.backtrack1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _93_Restore_IP_Addresses {
    //93. Restore IP Addresses
    //https://leetcode.com/problems/restore-ip-addresses/description/

    List<String> combinations = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        f(s, 0, new Stack<>());
        return combinations;
    }

    private void f(String s, int curPos, Stack<String> st) {
        if (st.size() > 4) return;
        if (curPos == s.length()) {
            if (st.size() < 4) return;
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < st.size(); i++) {
                tmp.append(st.get(i));
                if (i + 1 != st.size()) {
                    tmp.append(".");
                }
            }
            combinations.add(tmp.toString());
            return;
        }
        String num = "";

        for (int i = curPos; i < s.length() && i < curPos + 3; i++) {
            num += s.charAt(i);
            if (Integer.parseInt(num) > 256 || num.length() > 1 && num.charAt(0) == '0') return;
            st.push(num);
            f(s, i + 1, st);
            st.pop();
        }
    }
}
