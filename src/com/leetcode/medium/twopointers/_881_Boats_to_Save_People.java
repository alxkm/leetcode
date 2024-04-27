package com.leetcode.medium.twopointers;

import java.util.Arrays;

public class _881_Boats_to_Save_People {
    //881. Boats to Save People
    //https://leetcode.com/problems/boats-to-save-people/description/

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int boats = 0;
        while (l <= r) {
            if (people[r] + people[l] <= limit || l == r) {
                l++;
            }
            r--;
            boats++;
        }
        return boats;
    }
}
