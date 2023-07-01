package com.leetcode.medium.slidingwindow;

public class _424_Longest_Repeating_Character_Replacement {
    //https://leetcode.com/problems/longest-repeating-character-replacement/

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max = 0, left = 0, right = 0, mostFreq = 0;

        while (right < s.length()) {
            freq[s.charAt(right) -'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(right) - 'A']);

            if (right - left + 1 - mostFreq <= k) {
                max = Math.max(max, right - left + 1);
            } else {
                freq[s.charAt(left) -'A']--;
                left++;
            }
            right++;
        }
        return max;
    }
}
