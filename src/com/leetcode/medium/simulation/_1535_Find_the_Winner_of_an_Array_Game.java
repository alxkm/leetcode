package com.leetcode.medium.simulation;

public class _1535_Find_the_Winner_of_an_Array_Game {
    //1535. Find the Winner of an Array Game
    //https://leetcode.com/problems/find-the-winner-of-an-array-game/

    public int getWinner(int[] arr, int k) {
        int cur = arr[0];
        int count = 0;
        if (k >= arr.length) {
            for (int a: arr) {
                cur = Math.max(a, cur);
            }
            return cur;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > cur) {
                count = 1;
                cur = arr[i];
            } else {
                count++;
            }
            if (k == count) {
                return cur;
            }
        }
        return cur;
    }
}
