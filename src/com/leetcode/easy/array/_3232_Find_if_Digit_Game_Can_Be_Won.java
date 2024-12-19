package com.leetcode.easy.array;

public class _3232_Find_if_Digit_Game_Can_Be_Won {
    //3232. Find if Digit Game Can Be Won
    //https://leetcode.com/problems/find-if-digit-game-can-be-won/description/

    public boolean canAliceWin(int[] nums) {
        int one = 0, two = 0;
        for (int n: nums) {
            if (n < 10) one += n;
            else two += n;
        }

        return (one > two) || (two > one);
    }
}
