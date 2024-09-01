package com.leetcode.easy.hard;

public class _1518_Water_Bottles {
    //https://leetcode.com/problems/water-bottles/
    //1518. Water Bottles

    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = 0;
        while (numBottles > 0 && numBottles >= numExchange) {
            int div = numBottles / numExchange;
            cnt += div * numExchange;
            numBottles = numBottles % numExchange;
            numBottles += div;
        }
        return cnt + numBottles;
    }

    public int numWaterBottles1(int numBottles, int numExchange) {
        int drinken = 0;
        int full = numBottles;
        int empty = 0;
        while (full != 0) {
            drinken += full;
            empty += full % numExchange;
            full = full / numExchange;

            if (empty >= numExchange) full += empty / numExchange;
            empty = empty % numExchange;
        }
        return drinken;
    }

    public static void main(String[] args) {
        var sol = new _1518_Water_Bottles();
        int numBottles = 9, numExchange = 3;
        System.out.println(sol.numWaterBottles(numBottles, numExchange));
    }
}
