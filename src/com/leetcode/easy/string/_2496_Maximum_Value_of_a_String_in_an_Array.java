package com.leetcode.easy.string;

public class _2496_Maximum_Value_of_a_String_in_an_Array {
    //2496. Maximum Value of a String in an Array
    //https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/

    public int maximumValue(String[] strs) {
        int n = 0;

        for (var s: strs) {
            boolean isNum = true;
            for (int i = 0; i < s.length(); i++) {
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') continue;
                isNum = false;
            }
            if (isNum) {
                n = Math.max(Integer.parseInt(s), n);
            } else {
                n = Math.max(s.length(), n);
            }
        }

        return n;
    }
}
