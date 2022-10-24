package com.leetcode.easy;

public class _55_LengthOfLastWorld {
    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s.length() == 1) return 1;
            if (!s.contains(" ")) return s.length();
            int i = 0, max = 0, lmax = 0;
            while (i < s.length()) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    lmax++;
                    max = lmax;
                } else {
                    lmax = 0;
                }
                i++;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLastWord("   aaaaa dfd          fsfff    "));
    }
}
