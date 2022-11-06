package com.leetcode.easy.simulation;

public class _1103_Distribute_Candies_to_People {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ar = new int[num_people];
        int num = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies == 0) break;
                if (candies < num) {
                    ar[i] += candies;
                    candies = 0;
                    break;
                }
                ar[i] += num;
                candies -= num;
                num++;
            }
        }
        return ar;
    }
}
