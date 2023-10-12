package com.leetcode.easy.string;

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    //28. Find the Index of the First Occurrence in a String

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.equals("")) return -1;
        if (needle == null || needle.equals("")) return -1;

        return haystack.indexOf(needle);
    }
}
