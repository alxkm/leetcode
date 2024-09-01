package com.leetcode.easy.array;

public class _3120_Count_the_Number_of_Special_Characters_I {
    //https://leetcode.com/problems/count-the-number-of-special-characters-i/
    //3120. Count the Number of Special Characters I

    public int numberOfSpecialChars(String word) {
        int[] ar = new int[26];
        int[] ar1 = new int[26];
        for (char ch: word.toCharArray()) {
            if (ch < 'a') {
                ar[ch - 'A']++;
            } else if (ch >= 'a') {
                ar1[ch - 'a']++;
            }
        }
        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > 0 && ar1[i] > 0) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        var sol = new _3120_Count_the_Number_of_Special_Characters_I();
        System.out.println(sol.numberOfSpecialChars("aaAbcBC"));
    }
}
