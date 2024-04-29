package com.leetcode.easy;

public class _3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse {
    //3083. Existence of a Substring in a String and Its Reverse
    //https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/

    public boolean isSubstringPresent(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) return true;

            if (s.contains(String.valueOf(s.charAt(i)) + s.charAt(i - 1))) return true;
        }
        return false;
    }
}
