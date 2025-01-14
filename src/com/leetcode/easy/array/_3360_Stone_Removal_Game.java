package com.leetcode.easy.array;

public class _3360_Stone_Removal_Game {
    //3360. Stone Removal Game
    //https://leetcode.com/problems/stone-removal-game/description/

    public boolean canAliceWin(int n) {
        n -= 10;
        if (n < 0) return false;
        int prev = 9;
        boolean turn = false;
        while (n >= prev) {
            n -= prev;
            prev--;
            turn = !turn;
        }
        return turn ? false : true;
    }
}
