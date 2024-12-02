package com.leetcode.easy.string;

public class _3340_Check_Balanced_String {
    //https://leetcode.com/problems/check-balanced-string/description/
    //3340. Check Balanced String

    public boolean isBalanced(String num) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < num.length(); i++) {
            odd += num.charAt(i) - '0';
            i++;
            if (i < num.length())  even += num.charAt(i) - '0';
        }

        return even == odd;
    }
}
