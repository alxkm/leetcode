package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _1417_Reformat_The_String {
    //https://leetcode.com/problems/reformat-the-string/

    public String reformat(String s) {
        int d = 0, l = 0;
        List<Character> dd = new ArrayList<>();
        List<Character> ll = new ArrayList<>();
        if (s.length() == 1) return s;
        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                d++;
                dd.add(ch);
            } else {
                l++;
                ll.add(ch);
            }
        }
        if (l == s.length() || d == s.length() || Math.abs(l - d) > 1) {
            return "";
        }
        int i = dd.size(), j = ll.size();
        boolean startFromLetter = false;
        if (l > d) startFromLetter = true;
        StringBuilder sb = new StringBuilder();
        while (i > 0 || j > 0) {
            if (startFromLetter) {
                if (j > 0) {
                    sb.append(ll.get(j - 1));
                    j--;
                }
                if (i > 0) {
                    sb.append(dd.get(i - 1));
                    i--;
                }
            } else {
                if (i > 0) {
                    sb.append(dd.get(i - 1));
                    i--;
                }
                if (j > 0) {
                    sb.append(ll.get(j - 1));
                    j--;
                }
            }
        }
        return sb.toString();
    }
}
