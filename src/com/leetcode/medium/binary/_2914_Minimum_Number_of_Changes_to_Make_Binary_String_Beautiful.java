package com.leetcode.medium.binary;

public class _2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful {
    //https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/
    //2914. Minimum Number of Changes to Make Binary String Beautiful

    public int minChanges(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) counter++;
        }
        return counter;
    }
}
