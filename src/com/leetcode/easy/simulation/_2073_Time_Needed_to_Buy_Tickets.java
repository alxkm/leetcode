package com.leetcode.easy.simulation;

public class _2073_Time_Needed_to_Buy_Tickets {
    //2073. Time Needed to Buy Tickets
    //https://leetcode.com/problems/time-needed-to-buy-tickets/

    public int timeRequiredToBuy(int[] tickets, int k) {
        int counter = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) {
                counter += tickets[i];
            } else {
                counter += ((i <= k) ? tickets[k] : tickets[k] - 1);
            }
        }
        return counter;
    }


}
