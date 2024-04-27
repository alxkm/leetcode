package com.leetcode.medium.greedy;

public class _2125_Number_of_Laser_Beams_in_a_Bank {
    //https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
    //2125. Number of Laser Beams in a Bank

    public int numberOfBeams(String[] bank) {
        int prev = count(bank[0]);
        int cnt = 0;

        for (int i = 1; i < bank.length; i++) {
            int cur = count(bank[i]);
            if (cur == 0) {
                continue;
            }
            cnt += cur * prev;
            prev = cur;
        }
        return cnt;
    }

    private int count(String s) {
        int cnt = 0;
        for (char ch: s.toCharArray()) {
            cnt += ch - '0';
        }
        return cnt;
    }
}
