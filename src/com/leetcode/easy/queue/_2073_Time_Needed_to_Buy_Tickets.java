package com.leetcode.easy.queue;

public class _2073_Time_Needed_to_Buy_Tickets {
    //2073. Time Needed to Buy Tickets
    //https://leetcode.com/problems/time-needed-to-buy-tickets

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

    public static void main(String[] args) {
        var sol = new _2073_Time_Needed_to_Buy_Tickets();
        System.out.println(sol.timeRequiredToBuy(new int[]{15, 66, 3, 47, 71, 27, 54, 43, 97, 34, 94, 33, 54, 26, 15, 52, 20, 71, 88, 42, 50, 6, 66, 88, 36, 99, 27, 82, 7, 72}, 18));
    }
}
