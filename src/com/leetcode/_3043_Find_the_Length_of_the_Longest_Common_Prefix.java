package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _3043_Find_the_Length_of_the_Longest_Common_Prefix {
    //3043. Find the Length of the Longest Common Prefix
    //https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int n: arr2) {
            String s = Integer.valueOf(n).toString();
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }
        int max = 0;
        for (int n: arr1) {
            String s = Integer.valueOf(n).toString();
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (set.contains(sub)) {
                    max = Math.max(sub.length(), max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        var sol = new _3043_Find_the_Length_of_the_Longest_Common_Prefix();
        System.out.println(sol.longestCommonPrefix(ArrayUtil.of(1,10,200), ArrayUtil.of(1000)));
    }
}
