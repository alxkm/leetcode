package com.leetcode.easy.twopointers;

public class _696_Count_Binary_Substrings {
    //696. Count Binary Substrings
    //https://leetcode.com/problems/count-binary-substrings/

    public int countBinarySubstrings(String s) {
        int counter = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0, j = i, prev = i;
            if (ch[i] == '0') {
                while (j < n && ch[j] == '0') {
                    zeros++;
                    j++;
                }
                prev = j;
                while (j < n && ch[j] == '1') {
                    ones++;
                    j++;
                }
            } else {
                while (j < n && ch[j] == '1') {
                    ones++;
                    j++;
                }
                prev = j;
                while (j < n && ch[j] == '0') {
                    zeros++;
                    j++;
                }
            }
            counter += Math.min(zeros, ones);
            i = prev - 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        var sol = new _696_Count_Binary_Substrings();
        System.out.println(sol.countBinarySubstrings("00110011"));
    }
}
