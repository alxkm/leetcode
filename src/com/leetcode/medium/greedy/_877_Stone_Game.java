package com.leetcode.medium.greedy;

public class _877_Stone_Game {
    //https://leetcode.com/problems/stone-game/
    //877. Stone Game

    public boolean stoneGame(int[] ar) {
        int a = 0, b = 0;
        boolean aliceTurn = true;
        for (int i = 0, j = ar.length - 1; i < j;) {
            int max;
            if (ar[i] < ar[j]) {
                if (ar[j] + ar[i + 1] < ar[j] + ar[j - 1]) {
                    max = ar[i];
                    i++;
                } else {
                    max = ar[j];
                    j--;
                }
            } else {
                if (ar[i] + ar[i + 1] > ar[i] + ar[j - 1]) {
                    max = ar[j];
                    j--;
                } else {
                    max = ar[i];
                    i++;
                }
            }
            if (aliceTurn) {
                aliceTurn = false;
                a += max;
            } else {
                b += max;
                aliceTurn = true;
            }
        }

        //return a > b;
        return true;
    }

    public static void main(String[] args) {
        var sol = new _877_Stone_Game();
        System.out.println(sol.stoneGame(new int[] {3,7,3,2,5,1,6,3,10,7}));
    }
}
