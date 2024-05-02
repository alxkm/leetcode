package com.leetcode.medium.simulation;

import java.util.Arrays;

public class _950_Reveal_Cards_In_Increasing_Order {
    //950. Reveal Cards In Increasing Order
    //https://leetcode.com/problems/reveal-cards-in-increasing-order/

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ar = new int[deck.length];
        boolean skip = false;
        int i = 0;
        int j = 0;
        while (i < deck.length) {
            if (ar[j] == 0) {
                if (!skip) {
                    ar[j] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            j++;
            if (j >= deck.length) j = 0;
        }

        System.out.println(Arrays.toString(ar));
        return ar;
    }

    /*
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ar = new int[deck.length];
        int j = 0;
        for (int i = 0; i < deck.length; i += 2, j++) {
            ar[i] = deck[j];
        }

        boolean nextFromEnd = false;
        if (deck.length % 2 != 0) nextFromEnd = true;

        for (int i = 1, l = j, r = deck.length - 1; i < deck.length; i += 2) {
            if (nextFromEnd) {
                nextFromEnd = false;
                ar[i] = deck[r--];
            } else {
                nextFromEnd = true;
                ar[i] = deck[l++];
            }
        }

        return ar;
    }
    * */

}
