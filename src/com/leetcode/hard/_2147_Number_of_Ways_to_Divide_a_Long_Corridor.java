package com.leetcode.hard;

import java.util.ArrayList;

public class _2147_Number_of_Ways_to_Divide_a_Long_Corridor {
    //2147. Number of Ways to Divide a Long Corridor
    //https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/

    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        var l = new ArrayList<Integer>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                l.add(i);
            }
        }
        if (l.size() == 0 || l.size() % 2 != 0) return 0;

        long counter = 1;
        int prev = l.get(1);
        for (int i = 2; i < l.size(); i += 2) {
            int length = l.get(i) - prev;
            counter = (counter * length) % mod;
            prev = l.get(i + 1);
        }

        return (int)counter;
    }
}
