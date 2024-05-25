package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _830_Positions_of_Large_Groups {
    //830. Positions of Large Groups
    //https://leetcode.com/problems/positions-of-large-groups/description/

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ll = new ArrayList<>();
        char ch = s.charAt(0);
        int groupSize = 1;
        int prevIndex = 0;
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == ch) {
                groupSize++;
            }
            if (s.charAt(i) != ch || (i == s.length() - 1 && groupSize >= 3)) {
                if (groupSize >= 3) {
                    ll.add(List.of(prevIndex, (i == s.length() - 1 && s.charAt(i) == ch) ? i : i - 1));
                }
                groupSize = 1;
                prevIndex = i;
                ch = s.charAt(i);
            }
        }
        return ll;
    }
}
