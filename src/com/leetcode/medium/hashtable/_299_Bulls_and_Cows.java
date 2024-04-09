package com.leetcode.medium.hashtable;

public class _299_Bulls_and_Cows {
    //299. Bulls and Cows
    //https://leetcode.com/problems/bulls-and-cows/

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] expect = new int[10];
        int[] actual = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            expect[secret.charAt(i) - '0']++;
            actual[guess.charAt(i) - '0']++;
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                expect[secret.charAt(i) - '0']--;
                actual[secret.charAt(i) - '0']--;
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && actual[secret.charAt(i) - '0'] != 0) {
                cows++;
                actual[secret.charAt(i) - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
