package com.leetcode.easy.gametheory;

import java.util.ArrayList;
import java.util.List;

public class _2293_Min_Max_Game {
    //2293. Min Max Game
    //https://leetcode.com/problems/min-max-game/

    public int minMaxGame(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int n: nums) l.add(n);

        while (l.size() > 1 || l.size() == 0) {
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < l.size(); i++) {
                int first = l.get(i);
                int second = l.get(++i);
                i++;
                t.add(Math.min(first, second));
                if (i >= l.size()) continue;
                first = l.get(i);
                second = l.get(++i);
                t.add(Math.max(first, second));
            }
            l = t;
            if (l.size() == 1) break;
        }
        return l.get(0);
    }
}
