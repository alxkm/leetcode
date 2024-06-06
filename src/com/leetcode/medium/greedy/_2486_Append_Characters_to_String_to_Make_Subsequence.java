package com.leetcode.medium.greedy;

public class _2486_Append_Characters_to_String_to_Make_Subsequence {
    //2486. Append Characters to String to Make Subsequence
    //https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

    public static int appendCharacters(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int size = t.length();
        //for (int i = 0; i < s1.length; i++) {
        int j = 0, k = 0;
        while (j < t1.length && k < s1.length) {
            if (s1[k] == t1[j]) {
                j++;
            }
            k++;
        }
        if (j == t1.length) {
            return 0;
        }
        size = Math.min(size, t1.length - j);
        //}
        return size;
    }

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }
}
