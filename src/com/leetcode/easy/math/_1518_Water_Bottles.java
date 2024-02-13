package com.leetcode.easy.math;

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

    public static void main(String[] args) {
        var sol = new _1518_Water_Bottles();
        int numBottles = 9, numExchange = 3;
        System.out.println(sol.numWaterBottles(numBottles, numExchange));
    }
}
