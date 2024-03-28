package com.leetcode.easy.string;

public class _2937_Make_Three_Strings_Equal {
    //2937. Make Three Strings Equal
    //https://leetcode.com/problems/make-three-strings-equal/

    public int findMinimumOperations(String s1, String s2, String s3) {
        String s = s1.substring(0, 1);
        if (!s2.startsWith(s) || !s3.startsWith(s)) return -1;

        int i = 1;
        while (true) {
            if (s1.length() >= ++i) {
                s = s1.substring(0, i);
            }
            if ((i > s1.length() || i > s2.length() || i > s3.length())
                    || (!s2.startsWith(s) || !s3.startsWith(s))) {
                i--;
                int counter = 0;
                if (i < s1.length()) counter += s1.length() - i;
                if (i < s2.length()) counter += s2.length() - i;
                if (i < s3.length()) counter += s3.length() - i;

                return counter;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "abbd", s3 = "abbbbbb";
        var sol = new _2937_Make_Three_Strings_Equal();
        System.out.println(sol.findMinimumOperations(s1, s2, s3));
    }
}
