package com.leetcode.easy.gametheory;

public class _374_Guess_Number_Higher_or_Lower {
    //https://leetcode.com/problems/guess-number-higher-or-lower/description/
    //374. Guess Number Higher or Lower

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    private final int n = 1;

    int guess(int num) {
        if (num > n) return -1;
        if (num < n) return 1;
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int x = guess(m);
            if (x == 0) return m;
            if (x == -1) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
