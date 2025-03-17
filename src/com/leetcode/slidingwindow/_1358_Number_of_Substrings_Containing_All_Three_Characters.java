package com.leetcode.slidingwindow;

public class _1358_Number_of_Substrings_Containing_All_Three_Characters {
    //https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    //1358. Number of Substrings Containing All Three Characters

    public int numberOfSubstrings(String s) {
        int left = 0, right = 0;
        int counter = 0;
        int[] fr = new int[] { 0, 0, 0 };
        while (right < s.length()) {
            fr[s.charAt(right) - 'a']++;
            while (fr[0] > 0 && fr[1] > 0 && fr[2] > 0) {
                counter += s.length() - right;
                fr[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return counter;
    }
}
