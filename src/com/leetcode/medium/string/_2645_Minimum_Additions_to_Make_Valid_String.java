package com.leetcode.medium.string;

public class _2645_Minimum_Additions_to_Make_Valid_String {
    //https://leetcode.com/problems/minimum-additions-to-make-valid-string/

    public static int addMinimum(String word) {
        int counter = 0;
        char[] s = {'a', 'b', 'c'};
        char[] w = word.toCharArray();
        int i = 0, j = 0;
        while (i < w.length) {
            if (w[i] == s[j]) {
                i++;
            } else {
                counter++;
            }
            if (i == w.length - 1 && j != 2) {
                j++;
                while (j < 3) {
                    j++;
                    counter++;
                }
                break;
            }
            j++;
            if (j == 3) j = 0;
        }
        return counter;
    }

    public static void main(String[] args) {
        String w = "b";
        System.out.println(addMinimum(w));
    }
}
