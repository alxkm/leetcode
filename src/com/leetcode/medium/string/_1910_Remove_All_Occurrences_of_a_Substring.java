package com.leetcode.medium.string;

public class _1910_Remove_All_Occurrences_of_a_Substring {
    //https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
    //1910. Remove All Occurrences of a Substring

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.toString().contains(part)) {
            int i = sb.indexOf(part);
            sb.delete(i, i + part.length());
        }
        return sb.toString();
    }
}
