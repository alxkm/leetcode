package com.leetcode.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if ((strs[0].length() - 1 >= i + 1)
                    || (strs[0].length() - 1 == i)
            ) {
                if (strs[0].length() - 1 == i) {
                    sb.append(strs[0].substring(strs[0].length() - 1));
                } else if (i == 0) {
                    sb.append(strs[0].substring(0, i + 1));
                } else {
                    sb.append(strs[0], i, i + 1);
                }
            } else {
                return sb.toString();
            }

            for (String s : strs) {
                if (i >= s.length()) {
                    return sb.toString();
                }
                if (!s.startsWith(sb.toString())) {
                    return sb.toString().substring(0, sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix a = new LongestCommonPrefix();
        String[] ar = {"ab", "a"};
        System.out.println(a.longestCommonPrefix(ar));
    }
}
