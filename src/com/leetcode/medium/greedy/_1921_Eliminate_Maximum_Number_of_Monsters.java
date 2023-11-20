package com.leetcode.medium.greedy;

import java.util.Arrays;

public class _1921_Eliminate_Maximum_Number_of_Monsters {
    //https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
    //Array Greedy Sorting

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

    public static void main(String[] args) {
        var sol = new _1921_Eliminate_Maximum_Number_of_Monsters();
//        int[] dist = {1,3,4};
//        int[] speed = {1, 1, 1};
        int[] dist = {5,4,3,3,3};
        int[] speed = {1,1,5,3,1};
        System.out.println(sol.eliminateMaximum(dist, speed));
    }
}
