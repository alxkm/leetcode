package com.leetcode.easy.gametheory;

public class _1025_Divisor_Game {
    public boolean divisorGame(int n) {
        boolean is = true;
        while (n > 1) {
            if (is) is = false;
            else is = true;
            n -= 1;
        }
        return !is;
    }
}
