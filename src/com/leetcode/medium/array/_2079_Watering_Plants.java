package com.leetcode.medium.array;

public class _2079_Watering_Plants {
    //https://leetcode.com/problems/watering-plants/

    public int wateringPlants(int[] plants, int capacity) {
        int n = 0;
        int c = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] <= c) {
                n++;
            } else {
                c = capacity;
                n += (i + 1) + i;
            }

            c -= plants[i];
        }

        return n;
    }
}
