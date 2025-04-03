package com.leetcode.medium.prefix;

public class _2381_Shifting_Letters_II {
    //2381. Shifting Letters II
    //https://leetcode.com/problems/shifting-letters-ii/description/

    public String shiftingLetters(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] sh : shifts) {
            int start = sh[0];
            int end = sh[1];
            int direction = sh[2];

            shift[start] += (direction == 0) ? -1 : 1;
            if (end + 1 < n) {
                shift[end + 1] -= (direction == 0) ? -1 : 1;
            }
        }

        for (int i = 1; i < n; i++) {
            shift[i] += shift[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int pos = ch[i] - 'a';
            int newCharPos = (pos + shift[i]) % 26;
            if (newCharPos < 0) {
                newCharPos += 26;
            }
            ch[i] = (char) ('a' + newCharPos);
        }

        return String.valueOf(ch);
    }

    private char getChar(int direction, char ch) {
        if (ch == 'a' && direction == 0)
            return 'z';
        if (ch == 'z' && direction == 1)
            return 'a';
        return (char) (ch + ((direction == 0) ? -1 : 1));
    }
}
