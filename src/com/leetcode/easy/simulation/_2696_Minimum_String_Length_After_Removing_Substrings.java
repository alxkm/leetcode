package com.leetcode.easy.simulation;

public class _2696_Minimum_String_Length_After_Removing_Substrings {
    //2696. Minimum String Length After Removing Substrings
    //https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/

    public int minLength(String s) {
        for (int i = 0; i < 30; i++) {
            while (s.indexOf("AB") != -1) {
                int index = s.indexOf("AB");
                s = s.substring(0, index) + s.substring(index + 2);
            }

            while (s.indexOf("CD") != -1) {
                int index = s.indexOf("CD");
                s = s.substring(0, index) + s.substring(index + 2);
            }
        }
        return s.length();
    }
}
