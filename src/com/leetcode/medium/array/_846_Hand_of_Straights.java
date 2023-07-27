package com.leetcode.medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _846_Hand_of_Straights {
    //https://leetcode.com/problems/hand-of-straights/

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        //Set<Integer> set = new HashSet<>();
        //for (int n: hand) set.add(n);
        //if (set.size() == groupSize && hand.length == groupSize) return true;

        Arrays.sort(hand);
        Set<Integer> used = new HashSet<>();
        int kParts = hand.length / groupSize;

        while (kParts > 0) {
            int counter = 0;
            int prev = -1;
            for (int i = 0; i < hand.length && counter != groupSize; i++) {
                int cur = hand[i];
                if (prev != cur && (prev == -1 || prev + 1 == cur) && !used.contains(i)) {
                    used.add(i);
                    prev = cur;
                    counter++;
                }
            }
            if (counter != groupSize) return false;
            kParts--;
        }
        return true;
    }
}
