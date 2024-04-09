package com.leetcode.medium.sort;

import java.util.Arrays;

public class _1921_Eliminate_Maximum_Number_of_Monsters {
    //1921. Eliminate Maximum Number of Monsters
    //https://leetcode.com/problems/eliminate-maximum-number-of-monsters/

    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] ar = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            int t = 0;
            int amount = dist[i];
            if (amount < speed[i]) {
                t = 1;
            } else {
                t = amount / speed[i];
                if (amount % speed[i] != 0) {
                    t++;
                }
            }
            ar[i] = t;
        }
        Arrays.sort(ar);
        int size = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > i) size++;
            else break;
        }
        return size;
    }
}
