package com.leetcode.medium.backtrack1;

import java.util.HashSet;
import java.util.Set;

public class _1980_Find_Unique_Binary_String {
    //https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2025-02-20
    //1980. Find Unique Binary String

    Set<String> set = new HashSet<>();
    int n;

    public String findDifferentBinaryString(String[] nums) {
        this.n = nums[0].length();
        for (String s: nums) {
            set.add(s);
        }
        return f(new StringBuilder());
    }

    String f(StringBuilder sb) {
        if (sb.length() == n) {
            if (set.contains(sb.toString())) {
                return null;
            }
            return sb.toString();
        }

        sb.append('1');
        String s = f(sb);
        if (s != null) {
            return s;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append('0');
        s = f(sb);
        if (s != null) {
            return s;
        }
        sb.deleteCharAt(sb.length() - 1);
        return null;
    }
}
