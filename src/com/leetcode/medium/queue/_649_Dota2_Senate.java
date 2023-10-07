package com.leetcode.medium.queue;

import java.util.LinkedList;
import java.util.Queue;

public class _649_Dota2_Senate {
    //https://leetcode.com/problems/dota2-senate/
    //FOREIGN_SOLUTION
    //TOP

    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int f = r.remove();
            int s = d.remove();

            if (f < s) r.add(senate.length() + f);
            else d.add(senate.length() + s);
        }
        if (r.size() > 0) return "Radiant";
        return "Dire";
    }
}
