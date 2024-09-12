package com.leetcode.easy.array;

public class _2928_Distribute_Candies_Among_Children_I {
    //2928. Distribute Candies Among Children I
    //https://leetcode.com/problems/distribute-candies-among-children-i/description/

    public int distributeCandies(int n, int limit) {
        int counter = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


    public int distributeCandies1(int n, int limit) {
        int counter = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) break;
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
