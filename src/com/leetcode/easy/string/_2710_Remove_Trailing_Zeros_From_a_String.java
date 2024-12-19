package com.leetcode.easy.string;

public class _2710_Remove_Trailing_Zeros_From_a_String {
    //2710. Remove Trailing Zeros From a String
    //https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/

    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }
}
